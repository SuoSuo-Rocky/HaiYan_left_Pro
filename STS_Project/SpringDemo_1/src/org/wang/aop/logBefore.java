package org.wang.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class logBefore implements MethodBeforeAdvice {
	public void LogBefore() {

	}

	/*
	 * дǰ��֪ͨ�ľ��巽��
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ǰ��֪ͨ......");

	}
}
