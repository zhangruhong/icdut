package com.vtars.cdut.aao.Dao;

import java.util.List;

import com.vtars.cdut.aao.model.Pager;

public interface IBaseDao<T> {
	public void add(T t);

	public void update(T t);

	public void delete(int id);

	public T load(int id);

	public List<T> list(String hql, Object[] args);

	public List<T> list(String hql, Object args);

	public List<T> list(String hql);

	/**
	 * ͨ��hql��ȡһ����󣬽��з�ҳ����
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */

	public Pager<T> find(String hql, Object[] args);

	public Pager<T> find(String hql, Object obj);

	public Pager<T> find(String hql);

	/**
	 * ͨ��hql��ȡһ������
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryByHql(String hql, Object[] args);

	public Object queryByHql(String hql, Object obj);

	public Object queryByHql(String hql);

	/**
	 * ����hql����һ�����
	 * 
	 * @param hql
	 * @param args
	 */
	public void excuteByHql(String hql, Object[] args);

	public void executeByHql(String hql, Object obj);

	public void executeByHql(String hql);
}
