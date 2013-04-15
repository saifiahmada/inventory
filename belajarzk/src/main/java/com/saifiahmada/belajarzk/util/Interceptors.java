package com.saifiahmada.belajarzk.util;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import com.saifiahmada.belajarzk.util.LoginManager;

public class Interceptors implements Initiator {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doInit(Page page, Map arg) throws Exception {

		if (!LoginManager.getIntance().isAuthenticated()) {
			Executions.getCurrent().sendRedirect("login.zul");
		}
		String zulPath = page.getRequestPath();
		if (zulPath.contains("/")){
			zulPath = zulPath.replaceAll("\\/", "");
		}
		
		if (!LoginManager.getIntance().isRight(zulPath)){
			Executions.getCurrent().sendRedirect("accessdenied.zul");
		}
		 
	}

	public boolean doCatch(Throwable parsingError) throws Exception {
		return false;
	}

	public void doAfterCompose(Page page) throws Exception {
	}

	public void doFinally() throws Exception {
	}


}
