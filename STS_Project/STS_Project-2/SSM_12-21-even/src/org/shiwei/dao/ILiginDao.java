package org.shiwei.dao;

import java.util.List;

import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.entity.Self;

public interface ILiginDao {
	  Login queryLoginBystuId(int id);
	  List<Book> queryAllbook();
    
      List<Self> queryAllSelf(int stuId);
      
      Book querybookMessage(int boId);
      
      void deleteSelfByHost(Self self);
      
      
      Self querySelfByHost(Self self);
      
      void addSelfBook(Self self);
      
      void deletebookByboId(int boid);
      
      Book querybookByboId(int boid);
      
      void updatebookById(Book book);
      
      void addBookImg(Book book);
      
      void addLogin(Login login);
      
      Book searchbookByboName(String boname);
}
