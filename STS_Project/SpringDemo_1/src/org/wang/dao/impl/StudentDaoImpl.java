package org.wang.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.dao.IStudentDao;
import org.wang.entity.Student;

/*
 * <bean id="studentDao" class="org.wang.dao.StudentDaoImpl"></bean>
 * ���
 * @Component("studentDao")  +  xml �ļ��е�ɨ����ָ�� ���� 
 */
//@Component("studentDao")
@Repository
public class StudentDaoImpl implements IStudentDao {
	public void addStudent(Student student) {
		System.out.println("����ѧ��.....");
	}
}
