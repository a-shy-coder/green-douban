package team.sdguys.service.impl;

import team.sdguys.dao.impl.BookDaoImpl;
import team.sdguys.entity.Book;

import java.util.List;

public class BookPageService {
    BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> getBookByType(String type){
        return bookDao.getBookByType(type);
    }
}
