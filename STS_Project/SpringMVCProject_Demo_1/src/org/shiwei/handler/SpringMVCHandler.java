package org.shiwei.handler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shiwei.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


//如果要在  request 域中存放student4对象， 则同时将 该对象 放入到Session域中。
//@SessionAttributes(value="student4") //第一种写法，放一个 对象名
//n @SessionAttributes(types={Student.class,Address.class})  // 第二种写法， 放该类型对象的 所有对象。
// 接口/ 类/ 注解   配置
@Controller
@RequestMapping(value="SpringMVC")  // 映射
public class SpringMVCHandler {
	// 当有一个请求是 welcome 时， 就被我拦截了 
	// 则 调用地址  为 SpringMVC/welcome,先找类的，再找 方法的
  /*
   * @RequestMapping("welcome/abc") , 则调用 地址为：" SpringMVC/welcome/abc"
   * 当中的参数：  	method, 设置 请求方式，
   *            params: 设置参数，表示有这个属性， 可以用大括号写多个。
   *       -
   *       当中的 age!=23 表示 age请求当中的 age 属性 值 ， 不能是 23，也可以没有
   *       ！age , 表示不能有 age 这个属性。
   *       headers : 设置响应头 
   */     
	
	//@RequestMapping(value="welcome",method=RequestMethod.POST,params = {"name=shi","age!=23"})
	@RequestMapping("welcome/{name}")
	public String welcome(@PathVariable("name") String name){
		System.out.println(name);
//		 会增加 解析器中  perfix 和 suffix ---->/view/success.j
  // 默认 使用了 请求转发 的跳转 方式。
		return "success";  
	}
	
	@RequestMapping(value="testRest/{name}",method=RequestMethod.POST)
	public String testPost(@PathVariable("name") Integer name){
		System.out.println(name+"post: 增");
		// Service 层实现 真正的增
		return "success";  
	}
	
	@RequestMapping(value="testRest/{name}",method=RequestMethod.GET)
	public String testGet(@PathVariable("name") Integer name){
		System.out.println(name+"get: 查询");
		// Service 层实现 真正的增
		return "success";  
	}
	
	@RequestMapping(value="testRest/{name}",method=RequestMethod.DELETE)
	@ResponseBody
	public String testDelete(@PathVariable("name") Integer name){
		System.out.println(name+"delete: 删除");
		// Service 层实现 真正的增
		return "success";  
	}
	
	
	@RequestMapping(value="testRest/{name}",method=RequestMethod.PUT)
	@ResponseBody
	public String testPut(@PathVariable("name") Integer name){
		System.out.println(name+"put: 改变");
		// Service 层实现 真正的增
		return "success";  
	}
	
	
	@RequestMapping(value="testParam")
	public String testParam(@RequestParam("uname") String name
			,@RequestParam(value="uage",required=false,defaultValue="100") Integer id){
		System.out.println(name);
		System.out.println(id);
		// Service 层实现 真正的增
		return "success";  
	}
	
	
	
	
	@RequestMapping(value="testRequestHeader")
	public String testRequestHeader(@RequestHeader("Cookie") String name){
		System.out.println(name);
		// Service 层实现 真正的增
		return "success";  
	}
	
	
	
	@RequestMapping(value="testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String name){
		System.out.println("JSESSIONID = " + name);
		// Service 层实现 真正的增
		return "success";  
	}
	
	
	//该对象student的 属性名必须和 form 表单中的标签属性name 值一致(支持级联属性)
	@RequestMapping(value="testObjectProperties")
	public String testObjectProperties(Student student){
		System.out.println(student);
		
		// Service 层实现 真正的增
		return "success";  
	}
	
	
	//使用原生 Servlet 
	@RequestMapping("testServletAPI")
	public String  testServletAPI(HttpServletRequest request,HttpServletResponse response) {
		String uname = request.getParameter("uname");
		System.out.println(uname);
		return "success";
		
	}
	
	
	//返回既有 数据 又有 视图   ModelAanView 
	@RequestMapping("testModelAndView")
	public ModelAndView  testModelAndView() {
		//ModelAndView  Model---M   ; Viwe -----V 
		/*
		 * :view(success) 这种方式 也会添加 前缀和 后缀
		 * 给构造方法 赋值， 就时 给 View  视图 赋值。 
		 */
		ModelAndView mv = new ModelAndView("success"); 
		Student stu = new Student();
		stu.setAge(200);
		stu.setName("shiei1");
		
		mv.addObject("student1",stu); // 存入了 Request 域中了   程序(框架)自动放的
		return mv;
	}
	
	
	
	//返回既有 数据 又有 视图   ModelMap 
	@RequestMapping("testModelMap")
	public String  testModelMap(ModelMap modelmap) {
		Student stu = new Student();
		stu.setAge(200);
		stu.setName("shiei2");
		modelmap.put("student2",stu);  // 放到 Request 域中去了   程序(框架)自动放的
		
		return "success"; // 返回   View  页面
	}
	
	
	
	//返回既有 数据 又有 视图   Map
	@RequestMapping("testMap")
	public String  testMap(Map<String, Object> map) {
		Student stu = new Student();
		stu.setAge(200);
		stu.setName("shiei3");
		map.put("student3",stu);  // 放到 Request 域中去了  程序(框架)自动放的
		return "success";  // 返回 View  页面 
	}
	
	
	@RequestMapping("testModel")
	public String  testModel(Model model) {
		Student stu = new Student();
		stu.setAge(200);
		stu.setName("shiei4");
		model.addAttribute("student4",stu);// 放到 Request 域中去了     程序(框架)自动放的
		return "success";  //  返回  View  页面 
	}
	
	
	
	// 在该类中的任何一次的请求前， 都会 先 执行 @ModelAttribute 修饰的方法。
	@ModelAttribute
	public void  queryStudentById(Map<String, Object> map) {
		//模拟 调用 三层查询数据库的 操作
		Student student = new Student();
		student.setId(123);
		student.setAge(300);
		student.setName("shiwei");
		map.put("wang", student); //约定： map 的 key就是  此方法 的对应 方法的参数类型的 首字母小写。
		
	}
// 如果不一致， 需要 在 后置方法 的 参数类型名前 添加 @ModelAttribute("xxxx")
	
	//修改
	@RequestMapping("testModelAttribute")
	public String  testModelAttribute(@ModelAttribute("wang")Student student) {
		System.out.println("改前："+student);
		System.out.println(student.getId());
		System.out.println("改后 ："+student);
		return "success";  //  返回  View  页面 
	}
	
	//通过 MVC 配置   实现 jsp  到 jsp   
/*	@RequestMapping("direct")
	public String jsp_jsp() {
		
		System.out.println(" 没有 经过   我 哦！ ");
		return "success";
	}
	*/
	
	@RequestMapping("forward")
	public String forword() {
		System.out.println(" 我是 Forword !");
		return "forward:/view/success.jsp";
	}
	
	@RequestMapping("redirect")
	public String redirect() {
		System.out.println(" 我是 redirect !");
		return "redirect:/view/success.jsp";
	}
	
	
	// 类项转换器-
	@RequestMapping("testConverter")
	public String  testConverter(@RequestParam("studentInfo")Student student) {
		System.out.println(student);
		return "success";
	}
	
	
	// 数据 格式化 
/*@RequestMapping("dateFormatting")
	public String  dateFormatting(@Valid Student student, BindingResult  result,Map<String, Object> map) {
		//约定： 如果 Student 格式化 出错， 会将错误信息 传入第二个参数中 ---》 result  中。
		// 相当  于    异常 处理 
		System.out.println("Birthday=" + student.getBirthday());
		System.out.println("Id=" + student.getId());
		System.out.println("Email=" + student.getEmail());
		if(result.getErrorCount()>0) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
		         map.put("errors", result.getFieldErrors() );
		       
			}
		}
		return "success";
	}*/
	
         //通过 ajax 请求  Springmvc 
/*@ResponseBody的作用：
 * 告诉 SpringMVC ,此时 的返回 不是一个 View 页面，而是一个 ajax 调用的返回值。
 * 谁 调用我  ， 我 就 把 数据 返回给 谁 
 */
	    @ResponseBody
		@RequestMapping("testJson")
		public List<Student>  testJson() {
			// Controller - Service --dao 
			//StudentService studentService = new  StudentServiceImp();
			//List<Student> students = studentService.queryAllStudent();
			// 模拟  调用 service 的查询操作
			Student student  = new Student(1,"za",100);
			Student student2 = new Student(2,"ww",200);
			Student student3 = new Student(3,"xj",300);
			List<Student> students = new  ArrayList<Student>();
			students.add(student);
			students.add(student2);
			students.add(student3);
			
			return students;
		}
		
			
	    
//	        SpringMVC 实现 文件的 上传  
		@RequestMapping("testMultipartResolver")
		public String  multipartResolver(@RequestParam("desc") String desc,
				                         @RequestParam("file") MultipartFile file ) throws IOException {
			System.out.println("文件的 描述 信息=" + desc);
			// jsp 中 上传 的 文件 ： file 
			//拿到 流  就拿到  一切 了， 流 中 保存着 一切 信息 。
			InputStream input = file.getInputStream();
			// 获取 所要上传的 文件的 原始 文件名 
			String filename = file.getOriginalFilename();
			
			// 提前准备好 一个 输出流 ，让文件 上传到 服务器端的 某一个  硬盘文件中  。
			OutputStream out= new FileOutputStream("F:\\" + filename);
			
			//字节流  用 字节数组 作为 缓冲区
            byte[] bs = new byte[1024];
            int len = -1;
            //判断是否 还有数据 
            while((len = input.read(bs)) != -1) {
            	// 有数据 就将 数据  写入 输出流  中，到 服务器  
            	out.write(bs, 0, len);
            }
            // 关闭 流 
			out.close();
			input.close();
			System.out.println("上传 成功！  ");
			return "success";
		}
	    


      // c测试  拦截器 
		@RequestMapping("testInterceptor")
		public String testInterceptor() {
			System.out.println(" 处理请求的  方法......");
			return "success";
		}
		
		// 测试 异常 类 处理其他类中的异常 
		@RequestMapping("testException")
		public String testException() {
			System.out.println(1/0);
			return "success";
		}
		
		

   


	
	
	

}
