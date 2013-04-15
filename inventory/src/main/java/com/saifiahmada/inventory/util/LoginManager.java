package com.saifiahmada.inventory.util;

import java.util.List;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;


import com.saifiahmada.inventory.base.TrioBasePage;
import com.saifiahmada.inventory.bean.TrioMstmenu;
import com.saifiahmada.inventory.bean.TrioMstuser;
import com.saifiahmada.inventory.util.LoginManager;

public class LoginManager extends TrioBasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String KEY_USER_MODEL = LoginManager.class
			.getName()+"_MODEL";

	private TrioMstuser user;
	
	
	private LoginManager () {
		
	}
	
	public static LoginManager getIntance(){
		return getIntance(Sessions.getCurrent());
	}
	
	public static LoginManager getIntance(Session zkSession) {

		synchronized (zkSession) {
			
			LoginManager loginModel = (LoginManager) zkSession.getAttribute(KEY_USER_MODEL);
			if(loginModel == null){
				zkSession.setAttribute(KEY_USER_MODEL, 
						loginModel = new LoginManager());
			}
			return loginModel;
		}
	}
	
	public synchronized void logIn(String name, String Password){
		//TrioMstuser tempUser = getMasterFacade().getTrioMstuserDao().findByTrioMstuserName(name);
		TrioMstuser tempUser = getMasterFacade().getTrioMstuserDao().findUserByUsername("saifi");
		if(tempUser != null){
			user = tempUser;
		}else{
			user = null;
		}
	}
	
	public void logOff(){
		user = null;
	}
	
	public synchronized TrioMstuser getUser(){
		return user;
	}
	
	public synchronized boolean isAuthenticated(){
		return user != null;
	}
	
	/*
	 * interceptor untuk handling zul file yang diakses oleh user yang berhak
	 */
	
	/*
	 * isRight
	 * @param zulPath String
	 * @param user String
	 * @return false jika tidak berhak
	 * @return tru jika berhak
	 */
	public synchronized boolean isRight(String zulPath){
		
		boolean bol = false;
		
//		List<TrioMstmenu> listMenu = getMasterFacade().getTrioMstmenuDao().getListMenuByUser(getUserSession());
		List<TrioMstmenu> listMenu = getMasterFacade().getTrioMstmenuDao().getListMenuByUser("saifi");
		listMenu.add(new TrioMstmenu("T10NTWBSC001","","","index.zul","",1)); 
		listMenu.add(new TrioMstmenu("T10NTWBSC002","","","login.zul","",2));
		listMenu.add(new TrioMstmenu("T10NTWBSC003","","","accessdenied.zul","",3));
		listMenu.add(new TrioMstmenu("T10NTWBSC004","","","triohelp.zul","",4));
		
		for (TrioMstmenu mm : listMenu){
			if (mm.getVlocation().equalsIgnoreCase(zulPath)){ 
				bol = true;
			}
		}
		return bol;
	}
	
}
