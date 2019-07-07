package org.shiwei.service_Impl;

import org.shiwei.dao.IStudentDao;
import org.shiwei.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentDao tudentDao_Impl;
	
public StudentServiceImpl() {
	System.out.println("service");
}
	
	public StudentServiceImpl(IStudentDao studentDao_Impl) {
		super();
		this.tudentDao_Impl = studentDao_Impl;
	}

	public void setStudentDao_Impl(IStudentDao tudentDao_Impl) {
		this.tudentDao_Impl = tudentDao_Impl;
	}

	public IStudentDao getStudentDao_Impl() {
		return tudentDao_Impl;
	}

	@Override
	public String queryStudentName() {
		return tudentDao_Impl.queryStudentName();
	}

}
