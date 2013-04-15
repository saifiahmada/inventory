package com.saifiahmada.inventory.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.saifiahmada.inventory.usertrail.TrioEntityUserTrail;

/** @author Saifi Ahmada Feb 8, 2013 3:22:40 PM  **/

@Entity
@Table(name="TRIO_MSTUSERROLE")
public class TrioMstuserrole extends TrioEntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrioMstuserrolePK trioMstuserrolePK;
	
	@Column(name="VSTAT", length=1)
	private String vstat;
	
	@ManyToOne
	@JoinColumn(name="VUSERNAME", referencedColumnName="VUSERNAME", insertable=false, updatable=false)
	private TrioMstuser trioMstuser;
	
	@ManyToOne
	@JoinColumn(name="VROLEID", referencedColumnName="VROLEID", insertable=false, updatable=false)
	private TrioMstrole trioMstrole;
	
	public TrioMstuserrole() {
		this.trioMstuserrolePK = new TrioMstuserrolePK();
		this.trioMstrole = new TrioMstrole();
		this.trioMstuser = new TrioMstuser();
	}
	
	public TrioMstuserrole(String vusername, String vroleid) {
		this.trioMstuserrolePK = new TrioMstuserrolePK(vusername, vroleid);
	}

	public TrioMstrole getTrioMstrole() {
		return trioMstrole;
	}

	public void setTrioMstrole(TrioMstrole trioMstrole) {
		this.trioMstrole = trioMstrole;
	}

	public TrioMstuser getTrioMstuser() {
		return trioMstuser;
	}

	public void setTrioMstuser(TrioMstuser trioMstuser) {
		this.trioMstuser = trioMstuser;
	}

	public TrioMstuserrolePK getTrioMstuserrolePK() {
		return trioMstuserrolePK;
	}

	public void setTrioMstuserrolePK(TrioMstuserrolePK trioMstuserrolePK) {
		this.trioMstuserrolePK = trioMstuserrolePK;
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
				+ ((trioMstuserrolePK == null) ? 0 : trioMstuserrolePK
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
		TrioMstuserrole other = (TrioMstuserrole) obj;
		if (trioMstuserrolePK == null) {
			if (other.trioMstuserrolePK != null)
				return false;
		} else if (!trioMstuserrolePK.equals(other.trioMstuserrolePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstuserrole [trioMstuserrolePK=" + trioMstuserrolePK + "]";
	}
	
}

