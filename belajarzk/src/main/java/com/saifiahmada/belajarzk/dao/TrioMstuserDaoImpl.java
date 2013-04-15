package com.saifiahmada.belajarzk.dao;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.saifiahmada.belajarzk.bean.TrioMstmenu;
import com.saifiahmada.belajarzk.bean.TrioMstuser;
import com.saifiahmada.belajarzk.hibernate.TrioHibernateDaoSupport;
import com.saifiahmada.belajarzk.util.TrioDateUtil;

/** @author Saifi Ahmada Feb 7, 2013 4:53:16 PM  **/

public class TrioMstuserDaoImpl extends TrioHibernateDaoSupport implements TrioMstuserDao {

	@Transactional(readOnly=false)
	public void saveOrUpdate(TrioMstuser domain, String user) {
		// TODO , masbro
		try{
			save(domain, user);
			System.out.println("save");
		}catch(DataIntegrityViolationException dive){
			update(domain, user);
			System.out.println("update");
		}
		
	}

	@Transactional(readOnly=false)
	public void save(TrioMstuser domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVcreaby(user);
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().save(domain);
		getHibernateTemplate().flush();
	}

	@Transactional(readOnly=false)
	public void update(TrioMstuser domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVmodiby(user);
		domain.getUserTrailing().setDmodi(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().update(domain);
		getHibernateTemplate().flush();
	}

	public void delete(TrioMstuser domain) {
		// TODO , masbro
		
		
	}

	public List<TrioMstuser> findAll() {
		// TODO , masbro
		
		return getHibernateTemplate().find("from TrioMstuser"); 
	}

	public List<TrioMstuser> findByExample(TrioMstuser domain) {
		// TODO , masbro
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true) 
	public List<TrioMstuser> findByCriteria(TrioMstuser domain) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TrioMstuser.class);
		if (domain.getTrioMstuserPK().getVusername() != null){
			criteria = criteria.add(Restrictions.like("trioMstuserPK.vusername", "%"+domain.getTrioMstuserPK().getVusername().toUpperCase()+"%"));
			System.out.println(""+domain.getTrioMstuserPK().getVusername());
		}
		if (domain.getVstat() != null){
			criteria = criteria.add(Restrictions.eq("vstat", domain.getVstat()));
		}
		System.out.println("ukuran "+getHibernateTemplate().findByCriteria(criteria).size());
		return getHibernateTemplate().findByCriteria(criteria); 
	}

	public TrioMstuser findByPrimaryKey(TrioMstuser domain) {
		
		
		return null;
	}

	@Transactional(readOnly=true)
	public TrioMstuser findUserByUsername(String username) {
		// TODO , masbro
		String strQ = "select u from TrioMstuser u where u.trioMstuserPK.vusername = :vusername";
		Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(strQ);
		q.setString("vusername", username);
		return (TrioMstuser) q.uniqueResult();
	}
	
}

