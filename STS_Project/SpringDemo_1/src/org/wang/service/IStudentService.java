package org.wang.service;

import org.wang.entity.Student;

public interface IStudentService {
	void  addStudent(Student student);
	void deleteStudentByNO(int stuNo); 

}
