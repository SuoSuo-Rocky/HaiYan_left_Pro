package org.shiwei.service;


import java.util.List;

import org.shiwei.entity.Book;
import org.shiwei.entity.Login;

public interface ILoginService {
 Login  queryLoginBystuId(int id);
 List<Book> queryAllbookByboId();
}
