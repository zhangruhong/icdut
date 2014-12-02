package com.vtars.cdut.aao.Service;

import java.util.ArrayList;
import java.util.TreeSet;

import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;

public interface IGradeService {
	/**
	 * 批量入库成绩——需要判断成绩是否已经存在
	 * 
	 * @param studyid
	 * @param ts
	 */
	public void addGrades(TreeSet<GradeBean> ts,User u);

	/**
	 * 删除该用户的所有成绩记录
	 * 
	 * @param user
	 */
	public void deleteGrades(User user);

	/**
	 * 返回该学生的所有成绩记录
	 * 
	 * @param u
	 * @return
	 */
	public ArrayList<GradeBean> listGradesByUser(User u);

	/**
	 * 按条件查找
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public ArrayList<GradeBean> queryByHql(String hql, Object[] args);

	public  GradeBean queryLastDateGrades(String username);
}
