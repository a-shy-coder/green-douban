package team.sdguys.service.impl;

import team.sdguys.dao.BookRatingDao;
import team.sdguys.dao.impl.BookRatingDaoImpl;
import team.sdguys.entity.BookRating;
import team.sdguys.entity.BookRating;
import team.sdguys.service.BookRatingService;

/**
 * 图书评分业务接口的实现
 */
public class BookRatingServiceImpl implements BookRatingService {

    BookRatingDao bookRatingDao = new BookRatingDaoImpl();

    @Override
    public double findBookRatingByUidAndBookId(int uid, int bookId) {
        BookRating bookRating = bookRatingDao.getBookRatingByUidAndBookId(uid, bookId);
        if(bookRating == null){
            return 0;
        }else{
            return bookRating.getRating();
        }
    }

    @Override
    public int modifyBookRating(int uid, int bookId, double bookRating) {
        // 没有记录, 就插入一条记录,有记录, 就更新一条记录
        if(bookRatingDao.getBookRatingByUidAndBookId(uid,bookId) == null){
            return bookRatingDao.insertBookRating(uid,bookId,bookRating);
        }else{
            return bookRatingDao.updateBookRatingByUidAndBookId(uid, bookId, bookRating);
        }
    }
}
