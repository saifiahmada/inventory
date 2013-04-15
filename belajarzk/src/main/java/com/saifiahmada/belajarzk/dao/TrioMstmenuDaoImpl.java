package com.saifiahmada.belajarzk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.saifiahmada.belajarzk.bean.TrioMstmenu;
import com.saifiahmada.belajarzk.hibernate.TrioHibernateDaoSupport;
import com.saifiahmada.belajarzk.util.TrioDateUtil;

/** @author Saifi Ahmada Feb 7, 2013 4:47:57 PM  **/

public class TrioMstmenuDaoImpl extends TrioHibernateDaoSupport implements TrioMstmenuDao {

	public void saveOrUpdate(TrioMstmenu domain, String user) {
		// TODO , masbro
		try{
			save(domain, user);
			System.out.println("insert");
		}catch(DataIntegrityViolationException dive){
			update(domain, user);
			System.out.println("update");
		}
		
	}

	public void save(TrioMstmenu domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVcreaby(user);
		domain.getUserTrailing().setDcrea(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().save(domain);
	}

	public void update(TrioMstmenu domain, String user) {
		// TODO , masbro
		domain.getUserTrailing().setVmodiby(user);
		domain.getUserTrailing().setDmodi(TrioDateUtil.getLongSysDate());
		getHibernateTemplate().update(domain);
		
	}

	public void delete(TrioMstmenu domain) {
		// TODO , masbro
		
		
	}

	public List<TrioMstmenu> findAll() {
		// TODO , masbro
		return getHibernateTemplate().find("from TrioMstmenu");
	}

	public List<TrioMstmenu> findByExample(TrioMstmenu domain) {
		// TODO , masbro
		
		return null;
	}

	public List<TrioMstmenu> findByCriteria(TrioMstmenu domain) {
		// TODO , masbro
		DetachedCriteria c = DetachedCriteria.forClass(TrioMstmenu.class);
		if (domain.getTrioMstmenuPK().getVmenuid() != null){
			c = c.add(Restrictions.eq("trioMstmenuPK.vmenuid", domain.getTrioMstmenuPK().getVmenuid()));
		}
		if (domain.getVlocation() != null){
			c = c.add(Restrictions.eq("vlocation", domain.getVlocation()));
		}
		if (domain.getVimage() != null){
			c = c.add(Restrictions.eq("vimage", domain.getVimage()));
		}
		if (domain.getVtitle() != null){
			c = c.add(Restrictions.sqlRestriction("upper(vtitle) like ('%"+domain.getVtitle().toUpperCase()+"%') "));
		}
		if (domain.getVparent() != null){
			c = c.add(Restrictions.eq("vparent", domain.getVparent()));
		}
		return getHibernateTemplate().findByCriteria(c);
	}

	public TrioMstmenu findByPrimaryKey(TrioMstmenu domain) {
		// TODO , masbro
		
		return null;
	}

	@Transactional(readOnly=true) 
	public List<TrioMstmenu> getListMenuByUser(String user) {
		// TODO , masbro
		
		String st = "select mm.* from TRIO_MSTUSERROLE mur " +
					"join trio_mstaccessrole mar on mar.VROLEID = mur.VROLEID " +
					"join trio_mstmenu mm on mm.VMENUID = mar.VMENUID " +
					"where mur.VUSERNAME = :user and mar.VSTAT = 'A' " +
					"order by mm.vparent,mm.norderer asc";
		
		SQLQuery sq = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createSQLQuery(st);
		sq.setString("user", user);
		sq.addEntity(TrioMstmenu.class);
		
		List<TrioMstmenu> list = sq.list();
		return list;
	}

}

