package com.saifiahmada.belajarzk.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.saifiahmada.belajarzk.usertrail.TrioEntityUserTrail;

/**
 * @author glassfish | Saipi Ramli
 *
 * Oct 31, 2012
 */
@Entity
@Table(name="TRIO_MSTMENU")
public class TrioMstmenu extends TrioEntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TrioMstmenuPK trioMstmenuPK;
	
	@Column(name="VPARENT", length=6)
	private String vparent;
	
	@Column(name="VTITLE", length=100)
	private String vtitle;
	
	@Column(name="VLOCATION", length=30)
	private String vlocation;
	
	@Column(name="VIMAGE", length=30)
	private String vimage;
	
	@Column(name="NORDERER", length=3)
	private int norderer;
	
	@OneToMany(mappedBy="trioMstmenu")
	private Set<TrioMstaccessrole> trioMstaccessroleSet;
	
	public TrioMstmenu() {
		this.trioMstmenuPK = new TrioMstmenuPK();
	}
	
	public TrioMstmenu(String vmenuid) {
		this.trioMstmenuPK = new TrioMstmenuPK(vmenuid);
	}
	
	public TrioMstmenu(String vmenuid, String vparent, String vtitle, String vlocation, String vimage, int norderer ) {
		this.trioMstmenuPK = new TrioMstmenuPK(vmenuid);
		this.vparent = vparent;
		this.vtitle = vtitle;
		this.vlocation = vlocation;
		this.vimage = vimage;
		this.norderer = norderer;
	}

	public Set<TrioMstaccessrole> getTrioMstaccessroleSet() {
		return trioMstaccessroleSet;
	}

	public void setTrioMstaccessroleSet(Set<TrioMstaccessrole> trioMstaccessroleSet) {
		this.trioMstaccessroleSet = trioMstaccessroleSet;
	}

	public TrioMstmenuPK getTrioMstmenuPK() {
		return trioMstmenuPK;
	}

	public void setTrioMstmenuPK(TrioMstmenuPK trioMstmenuPK) {
		this.trioMstmenuPK = trioMstmenuPK;
	}

	public String getVparent() {
		return vparent;
	}

	public void setVparent(String vparent) {
		this.vparent = vparent;
	}

	public String getVtitle() {
		return vtitle;
	}

	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}

	public String getVlocation() {
		return vlocation;
	}

	public void setVlocation(String vlocation) {
		this.vlocation = vlocation;
	}

	public String getVimage() {
		return vimage;
	}

	public void setVimage(String vimage) {
		this.vimage = vimage;
	}

	public int getNorderer() {
		return norderer;
	}

	public void setNorderer(int norderer) {
		this.norderer = norderer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((trioMstmenuPK == null) ? 0 : trioMstmenuPK.hashCode());
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
		TrioMstmenu other = (TrioMstmenu) obj;
		if (trioMstmenuPK == null) {
			if (other.trioMstmenuPK != null)
				return false;
		} else if (!trioMstmenuPK.equals(other.trioMstmenuPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstmenu [trioMstmenuPK=" + trioMstmenuPK + "]";
	}

}
