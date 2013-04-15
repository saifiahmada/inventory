package com.saifiahmada.inventory.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Saifi Ahmada Feb 7, 2013 3:44:38 PM  **/

@Embeddable
public class TrioMstmenuPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="VMENUID", length=11, nullable=false)
	private String vmenuid;
	
	public TrioMstmenuPK() {
	
	}
	public TrioMstmenuPK(String vmenuid) {
		this.vmenuid = vmenuid;
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
		TrioMstmenuPK other = (TrioMstmenuPK) obj;
		if (vmenuid == null) {
			if (other.vmenuid != null)
				return false;
		} else if (!vmenuid.equals(other.vmenuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TrioMstmenuPK [vmenuid=" + vmenuid + "]";
	}
	
}

