package org.shiwei.spring.jdbc.service.Impl;

import org.shiwei.spring.jdbc.dao.JdbcDao;
import org.shiwei.spring.jdbc.service.JdbcService;

public class JdbcService_Impl implements JdbcService {
	private JdbcDao jdbcDao;
	

	public JdbcDao getJdbcDao() {
		return jdbcDao;
	}


	public void setJdbcDao(JdbcDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}


	@Override
	public void execute() {
		jdbcDao.execute();

	}

}
