package org.wang.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.dao.IStudentDao;
import org.wang.entity.Student;

public class StudentServiceImpl implements IStudentService {
	
	IStudentDao studentDao;
	
	
	

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void addStudent(Student student) {
//		if(��ѧ���Ƿ���� )
//		��������.....
		
		studentDao.addStudent(student);
	}
    
    @Override
    public void deleteStudentByNO(int stuNo) {
    	System.out.println("ɾ��ѧ��.....");
    	
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}
