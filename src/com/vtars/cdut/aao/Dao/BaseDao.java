package com.vtars.cdut.aao.Dao;

import java.lang.reflect.ParameterizedType;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.vtars.cdut.aao.model.Pager;
import com.vtars.cdut.aao.model.SystemContext;


public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private Class<T> clz;

	@SuppressWarnings("unchecked")
	private Class<T> getClz() {
		if (clz == null) {
			// 获取泛型的Class对象
			clz = ((Class<T>) (((ParameterizedType) (this.getClass()
					.getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(int id) {
		T t = this.load(id);
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T load(int id) {
		return this.getHibernateTemplate().load(getClz(), id);
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

	@Override
	public List<T> list(String hql, Object[] args) {
		Query q = setParamterQuery(hql, args);
		return q.list();
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[] { arg });
	}

	@Override
	public List<T> list(String hql) {
		return this.list(hql, null);
	}

	@Override
	public Pager<T> find(String hql, Object[] args) {
		// 应该是加载配置文件的-单页容量
		int pageSize = SystemContext.getPageSize();
		// 应该是加载配置文件的-起始页
		int pageOffset = SystemContext.getPageOffset();
		if (pageSize <= 0) {
			pageSize = 0;
		}
		if (pageOffset < 0) {
			pageOffset = 0;
		}
		// 设置查询条件
		Query query = setParamterQuery(hql, args);
		// 将配置信息中的分页（起始页和页面大小）数据载入
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
		String chql = getCountHql(hql);
		Query cq = setParamterQuery(chql, args);
		Pager<T> pager = new Pager<T>();
		pager.setPageOffset(pageOffset);
		pager.setPageSize(pageSize);
		List<T> datas = query.list();
		// 将数据放到pager中
		pager.setDatas(datas);
		// 获取总条数
		long totalRecord = (Long) cq.uniqueResult();
		pager.setTotalRecord(totalRecord);
		return pager;
	}

	private String getCountHql(String hql) {
		String s = hql.substring(0, hql.indexOf("from"));
		if (s == null || s.equals("")) {
			hql = "select count(*) " + hql;
		}
		hql = hql.replace(s, "select count(*) ");
		hql = hql.replace("fetch", "");
		return hql;
	}

	@Override
	public Pager<T> find(String hql, Object obj) {
		return this.find(hql, new Object[] { obj });
	}

	@Override
	public Pager<T> find(String hql) {
		return this.find(hql, null);
	}

	@Override
	public Object queryByHql(String hql, Object[] args) {
		Query query = setParamterQuery(hql, args);
		return query.uniqueResult();
	}

	@Override
	public Object queryByHql(String hql, Object obj) {
		return this.queryByHql(hql, new Object[] { obj });
	}

	@Override
	public Object queryByHql(String hql) {
		return this.queryByHql(hql, null);
	}

	@Override
	public void excuteByHql(String hql, Object[] args) {
		Query query = setParamterQuery(hql, args);
		query.executeUpdate();
	}

	@Override
	public void executeByHql(String hql, Object obj) {
		this.excuteByHql(hql, new Object[] { obj });
	}

	@Override
	public void executeByHql(String hql) {
		this.executeByHql(hql, null);
	}

}
