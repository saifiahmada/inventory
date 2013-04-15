package com.saifiahmada.belajarzk.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.saifiahmada.belajarzk.usertrail.TrioEntityUserTrail;

/**
 * @author glassfish | Saipi Ramli
 *
 * Oct 31, 2012
 */
@Entity
@Table(name="TRIO_MSTACCESSROLE") 
public class TrioMstaccessrole extends TrioEntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrioMstaccessrolePK trioMstaccessrolePK;
	@Column(name="VSTAT", length=1)
	private String vstat;
	
	@ManyToOne
	@JoinColumn(name="VMENUID", referencedColumnName="VMENUID", insertable=false, updatable=false)
	private TrioMstmenu trioMstmenu;
	
	@ManyToOne
	@JoinColumn(name="VROLEID", referencedColumnName="VROLEID", insertable=false, updatable=false)
	private TrioMstrole trioMstrole;
	
	public TrioMstaccessrole() {
		this.trioMstaccessrolePK = new TrioMstaccessrolePK();
		this.trioMstmenu = new TrioMstmenu();
		this.trioMstrole = new TrioMstrole();
	}
	
	public TrioMstaccessrole(String vroleid, String vmenuid) {
		this.trioMstaccessrolePK = new TrioMstaccessrolePK(vroleid, vmenuid);
	}

	public TrioMstrole getTrioMstrole() {
		return trioMstrole;
	}

	public void setTrioMstrole(TrioMstrole trioMstrole) {
		this.trioMstrole = trioMstrole;
	}

	public TrioMstmenu getTrioMstmenu() {
		return trioMstmenu;
	}

	public void setTrioMstmenu(TrioMstmenu trioMstmenu) {
		this.trioMstmenu = trioMstmenu;
	}

	public TrioMstaccessrolePK getTrioMstaccessrolePK() {
		return trioMstaccessrolePK;
	}

	public void setTrioMstaccessrolePK(TrioMstaccessrolePK trioMstaccessrolePK) {
		this.trioMstaccessrolePK = trioMstaccessrolePK;
	}

	public String getVstat() {
		return vstat;
	}

	public void setVstat(String vstat) {
		this.vstat = vstat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((trioMstaccessrolePK == null) ? 0 : trioMstaccessrolePK
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrioMstaccessrole other = (TrioMstaccessrole) obj;
		if (trioMstaccessrolePK == null) {
			if (other.trioMstaccessrolePK != null)
				return false;
		} else if (!trioMstaccessrolePK.equals(other.trioMstaccessrolePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstaccessrole [trioMstaccessrolePK=" + trioMstaccessrolePK
				+ "]";
	}
	
}
