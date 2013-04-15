package com.saifiahmada.inventory.facade;

import com.saifiahmada.inventory.dao.TrioMstaccessroleDao;
import com.saifiahmada.inventory.dao.TrioMstcabangDao;
import com.saifiahmada.inventory.dao.TrioMstmenuDao;
import com.saifiahmada.inventory.dao.TrioMstroleDao;
import com.saifiahmada.inventory.dao.TrioMstuserDao;
import com.saifiahmada.inventory.dao.TrioMstuserroleDao;

public class MasterFacade {
	
	protected TrioMstaccessroleDao trioMstaccessroleDao;
	
	protected TrioMstmenuDao trioMstmenuDao;
	
	protected TrioMstroleDao trioMstroleDao;
	
	protected TrioMstuserDao trioMstuserDao;
	
	protected TrioMstuserroleDao trioMstuserroleDao;
	
	protected TrioMstcabangDao trioMstcabangDao;
	
	public TrioMstcabangDao getTrioMstcabangDao() {
		return trioMstcabangDao;
	}

	public void setTrioMstcabangDao(TrioMstcabangDao trioMstcabangDao) {
		this.trioMstcabangDao = trioMstcabangDao;
	}

	public TrioMstuserroleDao getTrioMstuserroleDao() {
		return trioMstuserroleDao;
	}

	public void setTrioMstuserroleDao(TrioMstuserroleDao trioMstuserroleDao) {
		this.trioMstuserroleDao = trioMstuserroleDao;
	}

	public TrioMstaccessroleDao getTrioMstaccessroleDao() {
		return trioMstaccessroleDao;
	}

	public void setTrioMstaccessroleDao(TrioMstaccessroleDao trioMstaccessroleDao) {
		this.trioMstaccessroleDao = trioMstaccessroleDao;
	}

	public TrioMstmenuDao getTrioMstmenuDao() {
		return trioMstmenuDao;
	}

	public void setTrioMstmenuDao(TrioMstmenuDao trioMstmenuDao) {
		this.trioMstmenuDao = trioMstmenuDao;
	}

	public TrioMstroleDao getTrioMstroleDao() {
		return trioMstroleDao;
	}

	public void setTrioMstroleDao(TrioMstroleDao trioMstroleDao) {
		this.trioMstroleDao = trioMstroleDao;
	}

	public TrioMstuserDao getTrioMstuserDao() {
		return trioMstuserDao;
	}

	public void setTrioMstuserDao(TrioMstuserDao trioMstuserDao) {
		this.trioMstuserDao = trioMstuserDao;
	}
	
}
