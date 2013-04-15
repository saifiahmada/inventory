package com.saifiahmada.inventory.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saifiahmada.inventory.bean.TrioMstrole;
import com.saifiahmada.inventory.dao.TrioMstroleDao;
import com.saifiahmada.inventory.facade.MasterFacade;

/** @author Saifi Ahmada Feb 8, 2013 11:14:23 AM  **/

public class TestRole {
	
	public static void main(String[] args) {
		
		System.out.println("Mulai ");
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MasterFacade mf = (MasterFacade) ac.getBean("masterFacade");
		
		TrioMstroleDao dao = mf.getTrioMstroleDao();
		
		TrioMstrole role = new TrioMstrole("ROLE01");
		
		role.setVrolename("RO_CAB");
		
		dao.save(role, "saifi");
		
		System.out.println("selesai && sukses");
		
		
		
	}

}

