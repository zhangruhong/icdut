package com.vtars.cdut.aao.Dao.GradeDao;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.management.Query;

import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;

/**
 * ����ɼ��Ĳ��� ���� �������ӳɼ���AddGrades�� ���� ����ɾ���ɼ���deleteGrades�� ����
 * ���ĳ��ѧ���ĳɼ���ListGradesById�� ���������������ҳɼ���QueryByHql(String hql,Object[] args)��
 * 
 * 
 * @author jack
 *
 */
public interface IGradeDao {

	/**
	 * �������ɼ�������Ҫ�жϳɼ��Ƿ��Ѿ�����
	 * 
	 * @param studyid
	 * @param ts
	 */
	void AddGrades(TreeSet<GradeBean> ts);

	/**
	 * ɾ�����û������гɼ���¼
	 * 
	 * @param user
	 */
	void DeleteGrades(User user);

	/**
	 * ���ظ�ѧ�������гɼ���¼
	 * 
	 * @param u
	 * @return
	 */
	ArrayList<GradeBean> ListGradesByUser(User u);

	/**
	 * ����������
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	ArrayList<GradeBean> QueryByHql(String hql, Object[] args);

}
