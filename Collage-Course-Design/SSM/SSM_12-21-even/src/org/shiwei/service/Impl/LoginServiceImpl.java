package org.shiwei.service.Impl;


import java.util.List;

import org.shiwei.dao.ILiginDao;
import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.entity.Self;
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
	public List<Book> queryAllbook() {
		List<Book>  books = logindao.queryAllbook();
		return books;
	}
	
	@Override
	public List<Self> queryAllSelf(int stuId) {
		List<Self> allSelf = logindao.queryAllSelf(stuId);
		return allSelf;
	}

	@Override
	public Book querybookMessage(int boId) {
	    Book message = logindao.querybookMessage(boId);
		return message;
	}

	@Override
	public void deleteSelfByHost(Self self) {
		logindao.deleteSelfByHost(self);
	}

	@Override
	public Self querySelfByHost(Self self) {
		Self self2 = logindao.querySelfByHost(self);
		return self2;
	}

	@Override
	public void addSelfBook(Self self) {
		logindao.addSelfBook(self);
	}

	@Override
	public void deletebookByboId(int boid) {
		logindao.deletebookByboId(boid);
	}

	@Override
	public Book querybookByboId(int boid) {
		Book book = logindao.querybookByboId(boid);
		return book;
	}

	@Override
	public void updatebookById(Book book) {
		logindao.updatebookById(book);
	}

	@Override
	public void addBookImg(Book book) {
		logindao.addBookImg(book);
	}

	@Override
	public void addLogin(Login login) {
		logindao.addLogin(login);
		
	}

	@Override
	public Book searchbookByboName(String boname) {
		Book book = logindao.searchbookByboName(boname);
		return book;
	}

}
