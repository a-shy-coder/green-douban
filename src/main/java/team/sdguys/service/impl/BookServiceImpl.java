package team.sdguys.service.impl;

import team.sdguys.dao.BookDao;
import team.sdguys.dao.BookRatingDao;
import team.sdguys.dao.impl.BookDaoImpl;
import team.sdguys.dao.impl.BookRatingDaoImpl;
import team.sdguys.entity.Book;
import team.sdguys.entity.Book;
import team.sdguys.entity.BookRating;
import team.sdguys.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();
    BookRatingDao bookRatingDao = new BookRatingDaoImpl();

    @Override
    public int findBookIdByBookChineseName(String bookChineseName) {
        return bookDao.getBIdByBChineseName(bookChineseName);
    }

    @Override
    public Book findBookByBookId(int bookId) {
        return bookDao.getBookByBId(bookId);
    }

    @Override
    public List<Book> findBookListByBookIdList(List<Integer> bookIdList) {
        List<Book> bookList = new ArrayList<Book>();
        for(int id : bookIdList){
            bookList.add(findBookByBookId(id));
        }
        return bookList;
    }

    @Override
    public void modifyBookRatingByBookId(double rating, int bookId, int uid) {
        Book book = bookDao.getBookByBId(bookId);
        double bookRatingSum = (double) (book.getBRating() * book.getBRatingCount());
        bookRatingSum += rating;
        BookRating bookRating = bookRatingDao.getBookRatingByUidAndBookId(uid,bookId);
        int bookRatingCount = book.getBRatingCount() + 1;
        double currentRating = bookRatingSum / bookRatingCount;
        bookDao.updateBookRatingAndBookRatingCountByBookId(bookId,currentRating,bookRatingCount);
        
    }

    @Override
    public Book findBookById(int bookId) {
        return bookDao.getBookByBId(bookId);
    }

    @Override
    public List<Book> findTheTop5HighestRatedBooksByAuthorId(int authorId) {
        return bookDao.getTheTop5HighestRatedBooksByAuthorId(authorId);
    }

    @Override
    public List<Book> findTheLatest5BooksByAuthorId(int authorId) {
        return bookDao.getTheLatest5BooksByAuthorId(authorId);
    }

    @Override
    public List<Book> findBookByPage(int pageNo, int defaultPageSize) {
        return bookDao.getBookByPage(pageNo,defaultPageSize);
    }

    @Override
    public int getBookCount() {
        return bookDao.getBookCount();
    }

    @Override
    public int deleteBookById(int bookId) {
        return bookDao.deleteBookByBid(bookId);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int modifyBookById(Book book) {
        return bookDao.modifyBookById(book);
    }

    @Override
    public int modifyBookAuthorByBookId(int bookId, int authorId) {
        return bookDao.modifyBookAuthorByBookId(bookId,authorId);
    }
}
