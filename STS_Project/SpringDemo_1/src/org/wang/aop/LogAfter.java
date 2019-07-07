package org.wang.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("后置通知......,通知： 目标对象 "+ target + ",调用的方法名 ：" + method.getName() +"方法参数个数为:"
				+ args.length+", 方法的返回值为：" + returnValue );
	}
	

}
