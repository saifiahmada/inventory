package com.saifiahmada.inventory.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.saifiahmada.inventory.bean.TrioMstuserrole;
import com.saifiahmada.inventory.hibernate.TrioHibernateDaoSupport;
import com.saifiahmada.inventory.util.TrioDateUtil;

/** @author Saifi Ahmada Feb 8, 2013 4:14:31 PM  **/

public class TrioMstuserroleDaoImpl extends TrioHibernateDaoSupport implements TrioMstuserroleDao {

	public void saveOrUpdate(TrioMstuserrole domain, String user) {
		// TODO , masbro
		try{
			save(domain, user);
			System.out.println("insert");
		}catch (DataIntegrityViolationException dive) {
			update(domain, user);
			System.out.println("update");
		}
		
		
	}

	@Transactional(readOnly=false)
	public void save(TrioMstuserrole domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		domain.getUserTrailing().setVcreaby(user);
		getHibernateTemplate().save(domain);
		getHibernateTemplate().flush();
	}
	@Transactional(readOnly=false)
	public void update(TrioMstuserrole domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVmodiby(user);
		domain.getUserTrailing().setDmodi(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().update(domain);
		getHibernateTemplate().flush();
	}

	public void delete(TrioMstuserrole domain) {
		// TODO , masbro
		
		
	}

	@Transactional(readOnly=true)
	public List<TrioMstuserrole> findAll() {
		// TODO , masbro
		
		return getHibernateTemplate().find("from TrioMstuserrole");
	}

	@Transactional(readOnly=true)
	public List<TrioMstuserrole> findByExample(TrioMstuserrole domain) {
		// TODO , masbro
		
		return null;
	}

	@Transactional(readOnly=true)
	public List<TrioMstuserrole> findByCriteria(TrioMstuserrole domain) {
		// TODO , masbro
		DetachedCriteria c = DetachedCriteria.forClass(TrioMstuserrole.class);
		if (domain.getTrioMstuserrolePK().getVroleid() != null){
			c = c.add(Restrictions.eq("trioMstuserrolePK.vroleid", domain.getTrioMstuserrolePK().getVroleid()));
		}
		if (domain.getTrioMstuserrolePK().getVusername() != null){
			c = c.add(Restrictions.eq("trioMstuserrolePK.vusername", domain.getTrioMstuserrolePK().getVusername()));
		}
		if (domain.getVstat() != null){
			c = c.add(Restrictions.eq("vstat", domain.getVstat()));
		}
		return getHibernateTemplate().findByCriteria(c);
	}

	@Transactional(readOnly=true)
	public TrioMstuserrole findByPrimaryKey(TrioMstuserrole domain) {
		// TODO , masbro
		
		return null;
	}

}

