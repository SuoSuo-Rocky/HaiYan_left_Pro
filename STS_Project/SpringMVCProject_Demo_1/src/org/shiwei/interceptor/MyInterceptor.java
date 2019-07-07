package org.shiwei.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("拦截请求 ");
		// 过滤器 使用  filterChain 来控制 过滤 是否 放行 
		// 而 拦截器 使用此方法 的 返回值 ，true 表示 拦截之后 仍然 放行，false:拦截之后 撕票，请求终止，就像 打劫 一样
		
		return true;  
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("拦截响应");
		
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("视图被 渲染完毕 ");
		
	}



}
