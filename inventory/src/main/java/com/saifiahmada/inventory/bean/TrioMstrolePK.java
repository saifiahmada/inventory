package com.saifiahmada.inventory.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Saifi Ahmada Feb 7, 2013 4:00:11 PM  **/

@Embeddable
public class TrioMstrolePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="VROLEID", length=20, nullable=false)
	private String vroleid;
	
	public TrioMstrolePK() {
		
	}
	
	public TrioMstrolePK(String vroleid) {
		this.vroleid = vroleid;
	}

	public String getVroleid() {
		return vroleid;
	}

	public void setVroleid(String vroleid) {
		this.vroleid = vroleid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vroleid == null) ? 0 : vroleid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrioMstrolePK other = (TrioMstrolePK) obj;
		if (vroleid == null) {
			if (other.vroleid != null)
				return false;
		} else if (!vroleid.equals(other.vroleid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstrolePK [vroleid=" + vroleid + "]";
	}
	
}

