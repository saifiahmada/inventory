package com.saifiahmada.belajarzk.dao;

import java.util.List;

import com.saifiahmada.belajarzk.bean.TrioMstmenu;
import com.saifiahmada.belajarzk.hibernate.TrioGenericDao;

/** @author Saifi Ahmada Feb 7, 2013 4:47:13 PM  **/

public interface TrioMstmenuDao extends TrioGenericDao<TrioMstmenu> { 
	public List<TrioMstmenu> getListMenuByUser(String user);
}

