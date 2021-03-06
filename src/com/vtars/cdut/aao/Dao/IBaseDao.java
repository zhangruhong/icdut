package com.vtars.cdut.aao.Dao;

import java.util.List;

public interface IBaseDao<T> {
	public void add(T t);

	public void update(T t);

	public void delete(String id);

	public T load(String id);

	public List<T> list(String hql, Object[] args);

	public List<T> list(String hql, Object args);

	public List<T> list(String hql);

	/**
	 * 通过hql获取一组对象，进行分页处理
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */

//	public Pager<T> find(String hql, Object[] args);
//
//	public Pager<T> find(String hql, Object obj);
//
//	public Pager<T> find(String hql);

	/**
	 * 通过hql获取一个对象
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryByHql(String hql, Object[] args);

	public Object queryByHql(String hql, Object obj);

	public Object queryByHql(String hql);

	/**
	 * 调用hql更新一组对象
	 * 
	 * @param hql
	 * @param args
	 */
	public void excuteByHql(String hql, Object[] args);

	public void executeByHql(String hql, Object obj);

	public void executeByHql(String hql);
}
