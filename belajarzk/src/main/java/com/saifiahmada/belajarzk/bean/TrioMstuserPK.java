package com.saifiahmada.belajarzk.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Saifi Ahmada Feb 7, 2013 3:55:28 PM  **/

@Embeddable
public class TrioMstuserPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="VUSERNAME", length=20, nullable=false)
	private String vusername;
	
	public TrioMstuserPK() {
	
	}
	
	public TrioMstuserPK(String vusername) {
		this.vusername = vusername;
	}

	public String getVusername() {
		return vusername;
	}

	public void setVusername(String vusername) {
		this.vusername = vusername;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TrioMstuserPK other = (TrioMstuserPK) obj;
		if (vusername == null) {
			if (other.vusername != null)
				return false;
		} else if (!vusername.equals(other.vusername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstUserPK [vusername=" + vusername + "]";
	}
	
}

