package com.saifiahmada.belajarzk.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.saifiahmada.belajarzk.bean.TrioMstrole;
import com.saifiahmada.belajarzk.hibernate.TrioHibernateDaoSupport;
import com.saifiahmada.belajarzk.util.TrioDateUtil;

/** @author Saifi Ahmada Feb 7, 2013 4:52:00 PM  **/

public class TrioMstroleDaoImpl extends TrioHibernateDaoSupport implements TrioMstroleDao {

	public void saveOrUpdate(TrioMstrole domain, String user) {
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
	public void save(TrioMstrole domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVcreaby(user);
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().save(domain);
		getHibernateTemplate().flush();
	}

	@Transactional(readOnly=false)
	public void update(TrioMstrole domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVmodiby(user);
		domain.getUserTrailing().setDmodi(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().update(domain);
		getHibernateTemplate().flush();
	}

	public void delete(TrioMstrole domain) {
		// TODO , masbro
		
		
	}

	@Transactional(readOnly=true)
	public List<TrioMstrole> findAll() {
		// TODO , masbro
		
		return getHibernateTemplate().find("from TrioMstrole");
	}

	@Transactional(readOnly=true)
	public List<TrioMstrole> findByExample(TrioMstrole domain) {
		// TODO , masbro
		
		return null;
	}

	@Transactional(readOnly=true)
	public List<TrioMstrole> findByCriteria(TrioMstrole domain) {
		// TODO , masbro
		DetachedCriteria c = DetachedCriteria.forClass(TrioMstrole.class);
		if (domain.getTrioMstrolePK().getVroleid() != null){
			c = c.add(Restrictions.eq("trioMstrolePK.vroleid", domain.getTrioMstrolePK().getVroleid()));
		}
		if (domain.getVrolename() != null){
			c = c.add(Restrictions.like("vrolename", "%"+domain.getVrolename().toUpperCase()+"%"));
		}
		
		return getHibernateTemplate().findByCriteria(c);
	}

	public TrioMstrole findByPrimaryKey(TrioMstrole domain) {
		// TODO , masbro
		
		return null;
	}

}

