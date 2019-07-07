package org.shiwei.dao_Impl;

import org.shiwei.dao.IStudentDao;
import org.shiwei.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentDao_Impl implements IStudentDao {
	
	@Autowired
	Student ssss;

	public StudentDao_Impl() {
		System.out.println("dao");
	}

	public StudentDao_Impl(Student ssss) {
		super();
		this.ssss = ssss;
		
	}
	public void setStudent(Student student) {
		this.ssss = student;
	}
	public Student getStudent() {
		return ssss;
	}

	
	

	
	@Override
	public String queryStudentName() {
		
		return ssss.getStuName();
	}
	

}
