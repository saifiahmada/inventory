package com.saifiahmada.belajarzk.dao;

import java.util.List;

import com.saifiahmada.belajarzk.bean.TrioMstmenu;
import com.saifiahmada.belajarzk.bean.TrioMstuser;
import com.saifiahmada.belajarzk.hibernate.TrioGenericDao;

/** @author Saifi Ahmada Feb 7, 2013 4:52:49 PM  **/

public interface TrioMstuserDao extends TrioGenericDao<TrioMstuser> { 
	public TrioMstuser findUserByUsername(String username);
	
}

