package com.saifiahmada.inventory.base;

import java.sql.Connection;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;

import com.mchange.v2.c3p0.DataSources;
import com.saifiahmada.inventory.facade.MasterFacade;

/*
 * Created by Saifi Ramli $
 * 
 * Tue Sep 25 21:03:40 PM @ kos Bandaneira
 */

public class TrioBasePageVM  {
	
	/**
	 * 
	 */
	
	private static String userSession;
	
	private MasterFacade mf;
	
	public MasterFacade getMasterFacade() {
		MasterFacade mf = (MasterFacade) SpringUtil.getBean("masterFacade");
		return mf;
	}

	public static String getUserSession() {
		String username = (String) Sessions.getCurrent().getAttribute("username");
		System.out.println("username = "+username);
		userSession = username;
		return userSession;
	}

	public static void setUserSession(String userSession) {
		TrioBasePageVM.userSession = userSession;
	}
	
	public Connection getReportConnection(){
		
		DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
		Connection con = DataSourceUtils.getConnection(ds);
		return con;
	}

}
