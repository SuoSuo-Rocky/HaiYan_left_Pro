package org.wang.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.dao.IStudentDao;
import org.wang.entity.Student;

/*
 * <bean id="studentDao" class="org.wang.dao.StudentDaoImpl"></bean>
 * 相等
 * @Component("studentDao")  +  xml 文件中的扫描器指定 包名 
 */
//@Component("studentDao")
@Repository
public class StudentDaoImpl implements IStudentDao {
	public void addStudent(Student student) {
		System.out.println("增加学生.....");
	}
}
