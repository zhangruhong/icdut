package com.vtars.cdut.aao.Dao.GradeDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;

@Repository("gdao")
public class GradeDao extends HibernateDaoSupport implements IGradeDao {

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void addGrades(TreeSet<GradeBean> ts) {
		int i = 0;// 计数器
		if (null == ts || ts.isEmpty()) {
			return;
		}
		for (GradeBean gb : ts) {
			// TODO 想要批量插入提高性能 使用HibernateCallback思路吧
			Serializable id = this.getHibernateTemplate().save(gb);
			System.err.println(gb.toString());
			// 防止缓存溢出??
			/*
			 * if (i % 20 == 0) { this.getHibernateTemplate().flush();
			 * this.getHibernateTemplate().clear(); }
			 */
			System.out.println("Serializable id:" + id);
		}
	}

	@Override
	public void deleteGrades(User user) {
		int i = 0;// 计数器
		if (null == user) {
			return;
		}
		List<GradeBean> gds = listGradesByUser(user);

		// TODO 想要批量插入提高性能 使用HibernateCallback思路吧
		for (GradeBean gd : gds) {
			this.getHibernateTemplate().delete(gd);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GradeBean> listGradesByUser(User u) {
		if (null == u) {
			return null;
		}
		return (ArrayList<GradeBean>) this.getHibernateTemplate().find(
				"from GradeBean gb where gb.user= ?", u);
	}

	@Override
	public ArrayList<GradeBean> queryByHql(String hql, Object[] args) {
		Query query = setParamterQuery(hql, args);
		return (ArrayList<GradeBean>) query.list();
	}

	private Query setParamterQuery(String hql, Object[] args) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				q.setParameter(i, args[i]);
			}
		}
		return q;
	}
}
