package org.shiwei.dao.Impl;

import java.util.List;

import org.shiwei.dao.ILiginDao;
import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.mapper.BookMapper;
import org.shiwei.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements ILiginDao{
     
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	BookMapper bookMapper;
	
	public void setStudentMapper(LoginMapper loginMapper) {
		
		this.loginMapper = loginMapper;
	}
	
	
	public LoginMapper getStudentMapper() {
		return loginMapper;
	}
	
	@Override
	public Login queryLoginBystuId(int id) {
		System.out.println("dao.......id" + id );
		Login login = loginMapper.queryLoginBystuId(id);
		return login;
	}


	@Override
	public List<Book> queryAllbookByboId() {
		List<Book> books = bookMapper.queryAllbookByboId();
		return books;
	}

}
