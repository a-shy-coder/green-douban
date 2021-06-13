package team.sdguys.service.impl;

import team.sdguys.dao.AuthorDao;
import team.sdguys.dao.BookDao;
import team.sdguys.entity.Author;
import team.sdguys.entity.Book;
import team.sdguys.service.BookManagerService;

public class BookManagerServiceImpl implements BookManagerService {
    BookDao bookDao;
    AuthorDao authorDao;

    @Override
    public int addWholeBook(Book book) {
        Author author=authorDao.getAuthorByAuthorId( book.getAuthorId() );

        if(author==null){
            return 0;
        }
        else
            return bookDao.insertBook(book);
    }

    @Override
    public int deleteBookById(int bid) {
        return bookDao.deleteBookByBid(bid);
    }
}
