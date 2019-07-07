package org.wang.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("����֪ͨ......,֪ͨ�� Ŀ����� "+ target + ",���õķ����� ��" + method.getName() +"������������Ϊ:"
				+ args.length+", �����ķ���ֵΪ��" + returnValue );
	}
	

}
