package org.shiwei.dao;

import java.util.List;

import org.shiwei.entity.Book;
import org.shiwei.entity.Login;

public interface ILiginDao {
	  Login queryLoginBystuId(int id);
      List<Book> queryAllbookByboId();
}
