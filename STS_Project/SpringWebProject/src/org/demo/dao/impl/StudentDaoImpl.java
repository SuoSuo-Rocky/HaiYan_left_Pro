package org.demo.dao.impl;

import org.demo.dao.IStudentDao;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String queryStudentById() {
		System.out.println("我的数据库 ......");
		return "dfd";
	}
	
}
