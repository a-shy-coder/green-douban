package team.sdguys.service.impl;

import team.sdguys.dao.BookCommentDao;
import team.sdguys.dao.impl.BookCommentDaoImpl;
import team.sdguys.entity.BookComment;
import team.sdguys.entity.MovieComment;
import team.sdguys.service.BookCommentService;

import java.util.List;

/**
 * 图书评论业务接口实现类
 */
public class BookCommentServiceImpl implements BookCommentService {

    BookCommentDao bookCommentDao = new BookCommentDaoImpl();

    @Override
    public List<BookComment> findBookCommentListByBookId(int bookId) {
        return bookCommentDao.getBookCommentListByBookId(bookId);
    }

    @Override
    public int submitBookComment(BookComment bookComment) {
        return bookCommentDao.insertBookComment(bookComment);
    }

    @Override
    public int deleteComment(int bid, int uid) {
        return bookCommentDao.deleteComment(bid,uid);
    }

    @Override
    public int updateComment(int bid, int uid, String content) {
        return bookCommentDao.updateComment(bid,uid,content);
    }
}
