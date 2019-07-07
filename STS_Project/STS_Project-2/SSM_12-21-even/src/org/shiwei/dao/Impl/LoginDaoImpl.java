package org.shiwei.dao.Impl;

import java.util.List;

import org.shiwei.dao.ILiginDao;
import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.entity.Self;
import org.shiwei.mapper.BookMapper;
import org.shiwei.mapper.LoginMapper;
import org.shiwei.mapper.SelfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements ILiginDao{
     
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	SelfMapper selfMapper;

	@Override
	public Login queryLoginBystuId(int id) {
		System.out.println("dao.......id" + id );
		Login login = loginMapper.queryLoginBystuId(id);
		return login;
	}

	@Override
	public List<Book> queryAllbook() {
		List<Book> books = bookMapper.queryAllbook();
		return books;
	}

	@Override
	public List<Self>  queryAllSelf(int stuId) {
		List<Self> selfs = selfMapper.queryAllSelf(stuId);
		return selfs;
	}

	@Override
	public Book querybookMessage(int boId) {
		Book message = bookMapper.querybookMessage(boId);
		return message;
	}

	@Override
	public void deleteSelfByHost(Self self) {
        selfMapper.deleteSelfByHost(self);		
	}

	@Override
	public Self querySelfByHost(Self self) {
		Self self2 = selfMapper.querySelfByHost(self);
		return self2;
	}

	@Override
	public void addSelfBook(Self self) {
		selfMapper.addSelfBook(self);
	}

	@Override
	public void deletebookByboId(int boid) {
		bookMapper.deletebookByboId(boid);
	}

	@Override
	public Book querybookByboId(int boid) {
		Book querybookByboId = bookMapper.querybookByboId(boid);
		return querybookByboId;
	}

	@Override
	public void updatebookById(Book book) {
		bookMapper.updatebookById(book);
	}

	@Override
	public void addBookImg(Book book) {
		bookMapper.addBookImg(book);
	}

	@Override
	public void addLogin(Login login) {
		loginMapper.addLogin(login);
	}

	@Override
	public Book searchbookByboName(String boname) {
		Book book = bookMapper.searchbookByboName(boname);
		return book;
	}

}
