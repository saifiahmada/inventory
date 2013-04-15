package com.saifiahmada.inventory.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saifiahmada.inventory.bean.TrioMstmenu;
import com.saifiahmada.inventory.dao.TrioMstmenuDao;
import com.saifiahmada.inventory.facade.MasterFacade;

/** @author Saifi Ahmada Feb 7, 2013 2:59:01 PM  **/

public class TestMenu {
	
	public static void main(String[] args) {
		
		System.out.println("Mulai");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MasterFacade mf = (MasterFacade) ac.getBean("masterFacade");
		
		TrioMstmenuDao dao =  mf.getTrioMstmenuDao();
		
		TrioMstmenu menu = new TrioMstmenu("T10GLMST002");
		
		menu.setNorderer(2);
		menu.setVimage("/image/image.jpg");
		menu.setVlocation("mstCabang.zul");
		menu.setVparent("parent");
		menu.setVtitle("Master Perkiraan");
		
		dao.save(menu, "saifi");
		
		System.out.println("sukses");
	}

}

