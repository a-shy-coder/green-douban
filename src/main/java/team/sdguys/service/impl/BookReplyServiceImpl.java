package team.sdguys.service.impl;

import team.sdguys.dao.BookReplyDao;
import team.sdguys.dao.impl.BookReplyDaoImpl;
import team.sdguys.service.BookReplyService;

/**
 * 图书回复逻业务逻辑的接口的实现类
 */
public class BookReplyServiceImpl implements BookReplyService {

    BookReplyDao bookReplyDao = new BookReplyDaoImpl();

    @Override
    public void updateLikeCountByBookReplyId(int bookReplyId, int i) {
        bookReplyDao.updateLikeCountByBookReplyId(bookReplyId, i);
    }
}
