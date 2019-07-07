package org.shiwei.mapper;

import java.util.List;

import org.shiwei.entity.Book;

public interface BookMapper {
  List<Book>	queryAllbook();
  Book querybookMessage(int boId);
	
  Book querybookByboId(int boid);
  
  void deletebookByboId(int boid);
  
  void updatebookById(Book book);
  
  void addBookImg(Book book);
  
  Book searchbookByboName(String boname);
  
}
