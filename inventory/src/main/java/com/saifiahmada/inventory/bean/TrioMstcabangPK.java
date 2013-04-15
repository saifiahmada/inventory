package com.saifiahmada.inventory.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/** @author Saifi Ahmada Feb 15, 2013 10:29:58 AM  **/

@Embeddable
public class TrioMstcabangPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="KD_PRS", length=3, nullable=false)
	private String kdPrs;
	
	public TrioMstcabangPK() {
	
	}
	
	public TrioMstcabangPK(String kdPrs) {
		this.kdPrs = kdPrs;
	}

	public String getKdPrs() {
		return kdPrs;
	}

	public void setKdPrs(String kdPrs) {
		this.kdPrs = kdPrs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kdPrs == null) ? 0 : kdPrs.hashCode());
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
		TrioMstcabangPK other = (TrioMstcabangPK) obj;
		if (kdPrs == null) {
			if (other.kdPrs != null)
				return false;
		} else if (!kdPrs.equals(other.kdPrs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstcabangPK [kdPrs=" + kdPrs + "]";
	}
}

