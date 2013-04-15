package com.saifiahmada.inventory.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.saifiahmada.inventory.usertrail.TrioEntityUserTrail;


/** @author Saifi Ahmada Feb 7, 2013 3:23:53 PM  **/

@Entity
@Table(name="TRIO_MSTROLE")
public class TrioMstrole extends TrioEntityUserTrail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrioMstrolePK trioMstrolePK;
	@Column(name="VROLENAME") 
	private String vrolename;
	
	@OneToMany(mappedBy="trioMstrole") 
	private Set<TrioMstaccessrole> trioMstaccessroleSet;
	
	@OneToMany(mappedBy="trioMstrole")
	private Set<TrioMstuserrole> trioMstuserroleSet;
	
	public TrioMstrole() {
		this.trioMstrolePK = new TrioMstrolePK();
	}
	
	public TrioMstrole(String vroleid) {
		this.trioMstrolePK = new TrioMstrolePK(vroleid);
	}

	public Set<TrioMstaccessrole> getTrioMstaccessroleSet() {
		return trioMstaccessroleSet;
	}

	public void setTrioMstaccessroleSet(Set<TrioMstaccessrole> trioMstaccessroleSet) {
		this.trioMstaccessroleSet = trioMstaccessroleSet;
	}

	public TrioMstrolePK getTrioMstrolePK() {
		return trioMstrolePK;
	}

	public void setTrioMstrolePK(TrioMstrolePK trioMstrolePK) {
		this.trioMstrolePK = trioMstrolePK;
	}

	public String getVrolename() {
		return vrolename;
	}

	public void setVrolename(String vrolename) {
		this.vrolename = vrolename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((trioMstrolePK == null) ? 0 : trioMstrolePK.hashCode());
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
		TrioMstrole other = (TrioMstrole) obj;
		if (trioMstrolePK == null) {
			if (other.trioMstrolePK != null)
				return false;
		} else if (!trioMstrolePK.equals(other.trioMstrolePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstrole [trioMstrolePK=" + trioMstrolePK + "]";
	}
	
}

