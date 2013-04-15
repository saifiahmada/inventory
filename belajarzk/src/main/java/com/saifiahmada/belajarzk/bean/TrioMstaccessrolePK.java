package com.saifiahmada.belajarzk.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Saifi Ahmada Feb 7, 2013 4:12:29 PM  **/

@Embeddable
public class TrioMstaccessrolePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="VROLEID", length=20, nullable=false)
	private String vroleid;
	
	@Column(name="VMENUID", length=20, nullable=false)
	private String vmenuid;
	
	public TrioMstaccessrolePK() {
	}
	
	public TrioMstaccessrolePK(String vroleid, String vmenuid) {
		this.vroleid = vroleid;
		this.vmenuid = vmenuid;
				
	}

	public String getVroleid() {
		return vroleid;
	}

	public void setVroleid(String vroleid) {
		this.vroleid = vroleid;
	}

	public String getVmenuid() {
		return vmenuid;
	}

	public void setVmenuid(String vmenuid) {
		this.vmenuid = vmenuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vmenuid == null) ? 0 : vmenuid.hashCode());
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
		TrioMstaccessrolePK other = (TrioMstaccessrolePK) obj;
		if (vmenuid == null) {
			if (other.vmenuid != null)
				return false;
		} else if (!vmenuid.equals(other.vmenuid))
			return false;
		if (vroleid == null) {
			if (other.vroleid != null)
				return false;
		} else if (!vroleid.equals(other.vroleid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstaccessrolePK [vroleid=" + vroleid + ", vmenuid="
				+ vmenuid + "]";
	}

}

