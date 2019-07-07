package org.shiwei.handler;



import org.shiwei.exception.MyArrayIndexOutofBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("SecondMVC")
public class SecondSpringMVCHandler {
	
	
	//算数异常
	@RequestMapping("One")
	public  String testExceptionHandler() {
//		try {
			System.out.println(1/0);  //ArithmeticException： 算数异常
	/*	} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		return "success";
		
	}
	
	
	
	// 数组 越界 异常
	@RequestMapping("Three")
	public  String testExceptionHandler2() {
        int[] ne =  new int[2];
        System.out.println(ne[2]);
		return "success";
		
	}
	
	
	
	
/*	
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handlerArithmeticException2(ArithmeticException e) {
		System.out.println("222222我捕获了=-----" + e);
		ModelAndView modelAndView = new  ModelAndView("error");
		modelAndView.addObject("e",e);
		return modelAndView;
	}*/
	
/*	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerArithmeticException1(ArithmeticException e) {
		System.out.println("111111我捕获了=-----" + e);
		ModelAndView modelAndView = new  ModelAndView("error");
		modelAndView.addObject("e",e);
		return modelAndView;
	}*/
	
	
	
	
	
	
	
/*	// 该方法 可以捕获 本类中 抛出的  ArithmeticException 异常
	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})
	public ModelAndView handlerArithmeticException(ArithmeticException e) {
		System.out.println("我捕获了=-----" + e);
		ModelAndView modelAndView = new  ModelAndView("error");
		modelAndView.addObject("e",e);
		map.put("e", e);
		return modelAndView;
	}
	*/
	
	
	// 数组 越界 异常
	@RequestMapping("defineExcetpion1")
	public  String testSelfDefined(@RequestParam("i") Integer i ) throws MyArrayIndexOutofBoundsException {
		if(i == 3) {
			throw new MyArrayIndexOutofBoundsException();  //  抛出异常 
		}
		return "success";
		
	}
	
	
	@RequestMapping("defineExcetpion2")
	public  String testSelfDefined2(@RequestParam("i") Integer i )  {
		if(i == 3) {
			//去除 前缀和后 缀 
			return "redirect:testResponseStatus";
		}
		return "success";
		
	}
	
	//自定义 处理异常方法
	@ResponseStatus(value=HttpStatus.CONFLICT,
			        reason="我是自定义 处理异常方法，检测到你 这是数组越界了呀！  ")
	@RequestMapping("testResponseStatus")
	public  String testResponseStatus()  {	
		return "success";
	}
	
	// 使用 配置异常 类 
	@RequestMapping("SimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver() {
		System.out.println(1/0);
		return "error";
	}
	
	
	
	
	
	

}
