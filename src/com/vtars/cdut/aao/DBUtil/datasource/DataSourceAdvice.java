package com.vtars.cdut.aao.DBUtil.datasource;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class DataSourceAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice, ThrowsAdvice {
	// service����ִ��֮ǰ������
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("�����: " + target.getClass().getName() + "����"
				+ method.getName() + "����");
		if (method.getName().startsWith("add")
				|| method.getName().startsWith("create")
				|| method.getName().startsWith("save")
				|| method.getName().startsWith("edit")
				|| method.getName().startsWith("update")
				|| method.getName().startsWith("delete")
				|| method.getName().startsWith("remove")) {
			System.out.println("�л���: master");
			DataSourceSwitcher.setMaster();
		} else {
			System.out.println("�л���: slave");
			DataSourceSwitcher.setSlave();
		}
	}

	// service����ִ����֮�󱻵���
	public void afterReturning(Object arg0, Method method, Object[] args,
			Object target) throws Throwable {
	}

	// �׳�Exception֮�󱻵���
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable {
		DataSourceSwitcher.setSlave();
		System.out.println("�����쳣,�л���: slave");
	}

}
