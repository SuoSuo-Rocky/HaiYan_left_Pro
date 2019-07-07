package org.wang.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class logBefore implements MethodBeforeAdvice {
	public void LogBefore() {

	}

	/*
	 * 写前置通知的具体方法
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("前置通知......");

	}
}
