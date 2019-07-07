package org.demo.service.impl;

import org.demo.dao.IStudentDao;
import org.demo.dao.impl.StudentDaoImpl;
import org.demo.service.IStudentService;

public class StudentServiceImpl  implements   IStudentService{
	IStudentDao studentDao ;
	
	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String queryStudentById() {
		
	     return studentDao.queryStudentById();
		
	}
	

}
