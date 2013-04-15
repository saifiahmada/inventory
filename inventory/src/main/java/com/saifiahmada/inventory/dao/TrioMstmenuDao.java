package com.saifiahmada.inventory.dao;

import java.util.List;

import com.saifiahmada.inventory.bean.TrioMstmenu;
import com.saifiahmada.inventory.hibernate.TrioGenericDao;

/** @author Saifi Ahmada Feb 7, 2013 4:47:13 PM  **/

public interface TrioMstmenuDao extends TrioGenericDao<TrioMstmenu> { 
	public List<TrioMstmenu> getListMenuByUser(String user);
}

