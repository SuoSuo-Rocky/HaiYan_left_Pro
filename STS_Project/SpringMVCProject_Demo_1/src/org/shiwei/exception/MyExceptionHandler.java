package org.shiwei.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;



//不再 是控制器， 仅仅是  用于 处理异常 的类  
/*@RequestMapping("ExceptionHandler")*/
//@ControllerAdvice
public class MyExceptionHandler {    
	
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handlerArithmeticException2(ArithmeticException e) {
		System.out.println("标注有该@ControllerAdvice的类  捕获了=-----" + e);
		ModelAndView modelAndView = new  ModelAndView("error");
		modelAndView.addObject("e",e);
		return modelAndView;
	}
	
	
	

}
