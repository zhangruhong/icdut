package com.vtars.cdut.aao.Dao.GradeDao;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.management.Query;

import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;

/**
 * 定义成绩的操作 包括 批量增加成绩（AddGrades） 包括 批量删除成绩（deleteGrades） 包括
 * 查出某个学生的成绩（ListGradesById） 包括按照条件查找成绩（QueryByHql(String hql,Object[] args)）
 * 
 * 
 * @author jack
 *
 */
public interface IGradeDao {

	/**
	 * 批量入库成绩——需要判断成绩是否已经存在
	 * 
	 * @param studyid
	 * @param ts
	 * @param u 
	 */
	public void addGrades(TreeSet<GradeBean> ts, User u);

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
