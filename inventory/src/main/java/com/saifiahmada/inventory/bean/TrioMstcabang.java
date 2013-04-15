package com.saifiahmada.inventory.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.saifiahmada.inventory.usertrail.TrioEntityUserTrail;

/** @author Saifi Ahmada Feb 15, 2013 10:29:27 AM  **/

@Entity
@Table(name="TRIO_MSTCABANG")
public class TrioMstcabang extends TrioEntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrioMstcabangPK trioMstcabangPK;
	@Column(name="NM_PRS", length=35)
	private String nmPrs;
	@Column(name="ALM_PRS", length=40)
	private String almPrs;
	@Column(name="TELP1", length=11)
	private String telp1;
	@Column(name="TELP2", length=11)
	private String telp2;
	@Column(name="TELP3", length=11)
	private String telp3;
	@Column(name="FAX", length=11)
	private String fax;
	@Column(name="KD_PRS2", length=3)
	private String kdPrs2;
	
	public TrioMstcabang() {
		this.trioMstcabangPK = new TrioMstcabangPK();
	}
	
	public TrioMstcabang(String kdPrs) {
		this.trioMstcabangPK = new TrioMstcabangPK(kdPrs);
	}

	public TrioMstcabangPK getTrioMstcabangPK() {
		return trioMstcabangPK;
	}

	public void setTrioMstcabangPK(TrioMstcabangPK trioMstcabangPK) {
		this.trioMstcabangPK = trioMstcabangPK;
	}

	public String getNmPrs() {
		return nmPrs;
	}

	public void setNmPrs(String nmPrs) {
		this.nmPrs = nmPrs;
	}

	public String getAlmPrs() {
		return almPrs;
	}

	public void setAlmPrs(String almPrs) {
		this.almPrs = almPrs;
	}

	public String getTelp1() {
		return telp1;
	}

	public void setTelp1(String telp1) {
		this.telp1 = telp1;
	}

	public String getTelp2() {
		return telp2;
	}

	public void setTelp2(String telp2) {
		this.telp2 = telp2;
	}

	public String getTelp3() {
		return telp3;
	}

	public void setTelp3(String telp3) {
		this.telp3 = telp3;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getKdPrs2() {
		return kdPrs2;
	}

	public void setKdPrs2(String kdPrs2) {
		this.kdPrs2 = kdPrs2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((trioMstcabangPK == null) ? 0 : trioMstcabangPK.hashCode());
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
		TrioMstcabang other = (TrioMstcabang) obj;
		if (trioMstcabangPK == null) {
			if (other.trioMstcabangPK != null)
				return false;
		} else if (!trioMstcabangPK.equals(other.trioMstcabangPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstcabang [trioMstcabangPK=" + trioMstcabangPK + "]";
	}
	
}

