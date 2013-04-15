package com.saifiahmada.belajarzk.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.zkoss.zkplus.spring.SpringUtil;

import com.saifiahmada.belajarzk.facade.MasterFacade;

public class TrioHibernateDaoSupport extends HibernateDaoSupport {
	
	private MasterFacade masterFacade;

	public MasterFacade getMasterFacade() {
		masterFacade = (MasterFacade) SpringUtil.getBean("masterFacade");
		return masterFacade;
	}

	public void setMasterFacade(MasterFacade masterFacade) {
		this.masterFacade = masterFacade;
	}
	
	

}
