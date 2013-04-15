package com.saifiahmada.inventory.dao;

import java.util.List;

import com.saifiahmada.inventory.bean.TrioMstmenu;
import com.saifiahmada.inventory.bean.TrioMstuser;
import com.saifiahmada.inventory.hibernate.TrioGenericDao;

/** @author Saifi Ahmada Feb 7, 2013 4:52:49 PM  **/

public interface TrioMstuserDao extends TrioGenericDao<TrioMstuser> { 
	public TrioMstuser findUserByUsername(String username);
	
}

