package com.saifiahmada.belajarzk.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.saifiahmada.belajarzk.bean.TrioMstcabang;
import com.saifiahmada.belajarzk.hibernate.TrioHibernateDaoSupport;
import com.saifiahmada.belajarzk.util.TrioDateUtil;

/** @author Saifi Ahmada Feb 15, 2013 10:41:25 AM  **/

public class TrioMstcabangDaoImpl extends TrioHibernateDaoSupport implements TrioMstcabangDao {

	public void saveOrUpdate(TrioMstcabang domain, String user) {
		// TODO , masbro
		try{
			save(domain, user);
			System.out.println("insert");
		}catch(DataIntegrityViolationException dive){
			update(domain, user);
			System.out.println("update");
		}
		
	}

	@Transactional(readOnly=false)
	public void save(TrioMstcabang domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVcreaby(user);
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().save(domain);
		getHibernateTemplate().flush();
	}
	
	@Transactional(readOnly=false)
	public void update(TrioMstcabang domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVcreaby(user);
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().update(domain);
		getHibernateTemplate().flush();
	}

	public void delete(TrioMstcabang domain) {
		// TODO , masbro
		
		
	}

	@Transactional(readOnly=true)
	public List<TrioMstcabang> findAll() {
		// TODO , masbro
		
		return getHibernateTemplate().find("from TrioMstcabang");
	}

	@Transactional(readOnly=true)
	public List<TrioMstcabang> findByExample(TrioMstcabang domain) {
		// TODO , masbro
		
		return null;
	}

	@Transactional(readOnly=true)
	public List<TrioMstcabang> findByCriteria(TrioMstcabang domain) {
		// TODO , masbro
		DetachedCriteria c = DetachedCriteria.forClass(TrioMstcabang.class);
		if (domain.getTrioMstcabangPK().getKdPrs() != null){
			c = c.add(Restrictions.eq("trioMstcabangPK.kdPrs", domain.getTrioMstcabangPK().getKdPrs()));
		}
		if (domain.getNmPrs() != null){
			c = c.add(Restrictions.sqlRestriction("upper(nm_Prs) like ('%"+domain.getNmPrs().toUpperCase()+"%') "));
		}
		if (domain.getAlmPrs() != null){
			c = c.add(Restrictions.sqlRestriction("upper(alm_Prs) like ('%"+domain.getAlmPrs().toUpperCase()+"%') "));
		}
		if (domain.getTelp1() != null){
			c = c.add(Restrictions.sqlRestriction("upper(telp1) like ('%"+domain.getTelp1().toUpperCase()+"%') "));
		}
		return getHibernateTemplate().findByCriteria(c);
	}

	@Transactional(readOnly=true)
	public TrioMstcabang findByPrimaryKey(TrioMstcabang domain) {
		// TODO , masbro
		
		return null;
	}

}

