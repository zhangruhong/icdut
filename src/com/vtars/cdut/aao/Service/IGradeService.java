package com.vtars.cdut.aao.Service;

import java.util.ArrayList;
import java.util.TreeSet;

import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;

public interface IGradeService {
	/**
	 * �������ɼ�������Ҫ�жϳɼ��Ƿ��Ѿ�����
	 * 
	 * @param studyid
	 * @param ts
	 */
	public void addGrades(TreeSet<GradeBean> ts,User u);

	/**
	 * ɾ�����û������гɼ���¼
	 * 
	 * @param user
	 */
	public void deleteGrades(User user);

	/**
	 * ���ظ�ѧ�������гɼ���¼
	 * 
	 * @param u
	 * @return
	 */
	public ArrayList<GradeBean> listGradesByUser(User u);

	/**
	 * ����������
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public ArrayList<GradeBean> queryByHql(String hql, Object[] args);

	public  GradeBean queryLastDateGrades(String username);
}
