package org.shiwei.service.Impl;


import java.util.List;

import org.shiwei.dao.ILiginDao;
import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements ILoginService{
	
	 @Autowired
	ILiginDao logindao;
	 
	 
	public void setStudentdao(ILiginDao logindao) {
		this.logindao = logindao;
	}
	
	public ILiginDao getStudentdao() {
		return logindao;
	}
	
	@Override
	public Login queryLoginBystuId(int id) {
		Login login = logindao.queryLoginBystuId(id);
		return login;
	}

	@Override
	public List<Book> queryAllbookByboId() {
		List<Book>  books = logindao.queryAllbookByboId();
		
		return books;
	}
	

}
