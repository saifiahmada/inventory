package com.saifiahmada.inventory.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.saifiahmada.inventory.usertrail.TrioEntityUserTrail;

/** @author Saifi Ahmada Feb 7, 2013 3:23:26 PM  **/

@Entity
@Table(name="TRIO_MSTUSER")
public class TrioMstuser extends TrioEntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrioMstuserPK trioMstuserPK;
	
	@Column(name="VPASSWORD", length=64, nullable=false) 
	private String vpassword;
	
	@Column(name="VSTAT", length=1)
	private String vstat;
	
	@OneToMany(mappedBy="trioMstuser")
	private Set<TrioMstuserrole> trioMstuserroleSet;
	
	public TrioMstuser() {
		this.trioMstuserPK = new TrioMstuserPK();
	}
	
	public TrioMstuser(String vusername) {
		this.trioMstuserPK = new TrioMstuserPK(vusername);
	}
	
	public Set<TrioMstuserrole> getTrioMstuserroleSet() {
		return trioMstuserroleSet;
	}

	public void setTrioMstuserroleSet(Set<TrioMstuserrole> trioMstuserroleSet) {
		this.trioMstuserroleSet = trioMstuserroleSet;
	}

	public TrioMstuserPK getTrioMstuserPK() {
		return trioMstuserPK;
	}

	public void setTrioMstuserPK(TrioMstuserPK trioMstuserPK) {
		this.trioMstuserPK = trioMstuserPK;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
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
		result = prime * result
				+ ((trioMstuserPK == null) ? 0 : trioMstuserPK.hashCode());
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
		TrioMstuser other = (TrioMstuser) obj;
		if (trioMstuserPK == null) {
			if (other.trioMstuserPK != null)
				return false;
		} else if (!trioMstuserPK.equals(other.trioMstuserPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstUser [trioMstuserPK=" + trioMstuserPK + "]";
	}
	
}

