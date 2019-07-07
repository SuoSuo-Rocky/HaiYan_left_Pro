package org.wang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.dao.impl.StudentDaoImpl;
import org.wang.entity.AllCollectionType;
import org.wang.entity.Course;
import org.wang.entity.Student;
import org.wang.service.IStudentService;
import org.wang.service.StudentServiceImpl;

public class test {

	public void SpringIOC() {

	}

	public static void main(String[] args) {
/*		
		 * Student shi = new Student(); shi.setStuNo(12); shi.setStuName("shiwei");
		 * shi.setStuAge(100);
		 
		// spring ������ ���� ��context
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ִ�д�Spring IOC ������ ��ȡ һ��id Ϊ student �Ķ��� ��
		Student shi = (Student) context.getBean("Student");

		System.out.println(shi);
//     1. ���� new l
		// 2. �������Եĸ�ֵ
*/
		
//		learnCourseWithIOC();
		textDI();
//		collectionDemo();
		
//		testAOP();
		
		
	}

  public static void learnCourse(String name) {
	 
   
	}
  
  public static void learnCourseWithFactory() {
//	  ICourse course =  CourseFactory.getCourse("java");
//	  ICourse course2 =  CourseFactory.getCourse("html");
	  
	  Student student =new Student();
	  student.learn("java");
  }
  
  public static void learnCourseWithIOC() {
	// spring ������ ���� ��context
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// ִ�д�Spring IOC ������ ��ȡ һ��id Ϊ student �Ķ��� ��
	Student shi = (Student) context.getBean("Student");
	shi.learn("javaCourse");
	  
  }
  
  public static void textDI() {
	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	 Course  cou = (Course) context.getBean("course");
	  cou.showinfo(); 
  }
  
  public static void collectionDemo() {
	  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	   AllCollectionType collectionType = (AllCollectionType)context.getBean("collectionDemo");
	   System.out.println(collectionType);
  }
  
  public static void testAOP() {
	  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	  IStudentService impl = (IStudentService)context.getBean("StudentService");
	  Student stu = new Student();
	  stu.setStuAge(12);
	  stu.setStuName("wang");
	  impl.addStudent(stu);
	  
	  impl.deleteStudentByNO(12);
  }
  
  
 
  
}
