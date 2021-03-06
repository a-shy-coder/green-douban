package team.sdguys.service.impl;

import team.sdguys.dao.BookReplyDao;
import team.sdguys.dao.impl.BookReplyDaoImpl;
import team.sdguys.entity.BookReply;
import team.sdguys.service.BookReplyService;

import java.util.List;

/**
 * 图书回复逻业务逻辑的接口的实现类
 */
public class BookReplyServiceImpl implements BookReplyService {

    BookReplyDao bookReplyDao = new BookReplyDaoImpl();

    @Override
    public void updateLikeCountByBookReplyId(int bookReplyId, int i) {
        bookReplyDao.updateLikeCountByBookReplyId(bookReplyId, i);
    }

    @Override
    public List<BookReply> getBookReplyListByBookCommentId(int bcId) {
        return bookReplyDao.getBookReplyListByBookCommentId(bcId);
    }

    @Override
    public int submitBookReply(BookReply bookReply) {
        return bookReplyDao.insertReply(bookReply);
    }

    @Override
    public List<BookReply> findBookReplyListByUid(int uid) {
        return bookReplyDao.getBookReplyListByUid(uid);
    }

    @Override
    public int deleteBookReplyByBookReplyId(int bookReplyId) {
        return bookReplyDao.deleteBookReplyByBookReplyId(bookReplyId);
    }
}
