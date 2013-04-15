package com.saifiahmada.belajarzk.facade;

import com.saifiahmada.belajarzk.dao.TrioMstaccessroleDao;
import com.saifiahmada.belajarzk.dao.TrioMstcabangDao;
import com.saifiahmada.belajarzk.dao.TrioMstmenuDao;
import com.saifiahmada.belajarzk.dao.TrioMstroleDao;
import com.saifiahmada.belajarzk.dao.TrioMstuserDao;
import com.saifiahmada.belajarzk.dao.TrioMstuserroleDao;

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
