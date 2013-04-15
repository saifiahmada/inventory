package com.saifiahmada.belajarzk.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Saifi Ahmada Feb 8, 2013 3:16:16 PM  **/

@Embeddable
public class TrioMstuserrolePK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="VUSERNAME", length=20, nullable=false)
	private String vusername;
	@Column(name="VROLEID", length=20,nullable=false)
	private String vroleid;
	
	public TrioMstuserrolePK() {
	
	}
	
	public TrioMstuserrolePK(String vusername, String vroleid) {
		this.vusername = vusername;
		this.vroleid = vroleid;
	}

	public String getVusername() {
		return vusername;
	}

	public void setVusername(String vusername) {
		this.vusername = vusername;
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
		result = prime * result
				+ ((vusername == null) ? 0 : vusername.hashCode());
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
		TrioMstuserrolePK other = (TrioMstuserrolePK) obj;
		if (vroleid == null) {
			if (other.vroleid != null)
				return false;
		} else if (!vroleid.equals(other.vroleid))
			return false;
		if (vusername == null) {
			if (other.vusername != null)
				return false;
		} else if (!vusername.equals(other.vusername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstuserrolePK [vusername=" + vusername + ", vroleid="
				+ vroleid + "]";
	}
	
}

