package com.saifiahmada.belajarzk.test;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.jhlabs.image.ContrastFilter;
import com.saifiahmada.belajarzk.bean.TrioMstuserrole;
import com.saifiahmada.belajarzk.dao.TrioMstuserroleDao;
import com.saifiahmada.belajarzk.facade.MasterFacade;

/** @author Saifi Ahmada Feb 8, 2013 3:35:57 PM  **/

public class TestMstuserrole {
	
	public static void main(String[] args) {
		System.out.println("Mulai");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MasterFacade mf = (MasterFacade) ac.getBean("masterFacade");
		
		TrioMstuserroleDao dao = mf.getTrioMstuserroleDao();
		
		TrioMstuserrole userrole = new TrioMstuserrole("arya", "ROLE01");
		userrole.setVstat("A");
		try {
			dao.save(userrole, "saifi");
		}catch (DataIntegrityViolationException	cve) {
			System.out.println("ada data yg sama bos");
			//cve.printStackTrace();
		}
		
	}
}

