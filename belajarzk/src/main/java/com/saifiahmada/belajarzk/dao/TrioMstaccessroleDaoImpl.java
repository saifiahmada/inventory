package com.saifiahmada.belajarzk.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.saifiahmada.belajarzk.bean.TrioMstaccessrole;
import com.saifiahmada.belajarzk.hibernate.TrioHibernateDaoSupport;
import com.saifiahmada.belajarzk.util.TrioDateUtil;

/** @author Saifi Ahmada Feb 7, 2013 4:50:17 PM  **/

public class TrioMstaccessroleDaoImpl extends TrioHibernateDaoSupport implements TrioMstaccessroleDao {

	public void saveOrUpdate(TrioMstaccessrole domain, String user) {
		// TODO , masbro
		try{
			save(domain, user);
			System.out.println("insert");
		}catch(DataIntegrityViolationException devi){
			update(domain, user);
			System.out.println("update");
		}
		
	}

	@Transactional(readOnly=false)
	public void save(TrioMstaccessrole domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVcreaby(user);
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().save(domain);
		getHibernateTemplate().flush();
	}

	@Transactional(readOnly=false)
	public void update(TrioMstaccessrole domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVmodiby(user);
		domain.getUserTrailing().setDmodi(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().update(domain);
		getHibernateTemplate().flush();
	}

	public void delete(TrioMstaccessrole domain) {
		// TODO , masbro
		
		
	}

	@Transactional(readOnly=true)
	public List<TrioMstaccessrole> findAll() {
		// TODO , masbro
		
		return getHibernateTemplate().find("from TrioMstaccessrole");
	}

	@Transactional(readOnly=true)
	public List<TrioMstaccessrole> findByExample(TrioMstaccessrole domain) {
		// TODO , masbro
		
		return null;
	}

	@Transactional(readOnly=true)
	public List<TrioMstaccessrole> findByCriteria(TrioMstaccessrole domain) {
		// TODO , masbro
		DetachedCriteria c = DetachedCriteria.forClass(TrioMstaccessrole.class);
		if (domain.getTrioMstaccessrolePK().getVroleid() != null){
			c = c.add(Restrictions.eq("trioMstaccessrolePK.vroleid", domain.getTrioMstaccessrolePK().getVroleid()));
		}
		if (domain.getTrioMstaccessrolePK().getVmenuid() != null){
			c = c.add(Restrictions.eq("trioMstaccessrolePK.vmenuid", domain.getTrioMstaccessrolePK().getVmenuid()));
		}
		if (domain.getVstat() != null){
			c = c.add(Restrictions.eq("vstat", domain.getVstat()));
		}
		return getHibernateTemplate().findByCriteria(c);
	}

	public TrioMstaccessrole findByPrimaryKey(TrioMstaccessrole domain) {
		// TODO , masbro
		
		return null;
	}

}

