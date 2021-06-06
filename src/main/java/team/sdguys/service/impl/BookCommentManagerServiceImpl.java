package team.sdguys.service.impl;

import team.sdguys.dao.BookCommentDao;
import team.sdguys.dao.BookDao;
import team.sdguys.entity.BookComment;
import team.sdguys.service.BookCommentManagerService;

public class BookCommentManagerServiceImpl implements BookCommentManagerService {
    BookCommentDao bookCommentDao;
    BookDao bookDao;
    @Override
    public int deleteBookCommentByBidAndUid(int bid, int uid) {
        BookComment bookComment=new BookComment(0,bid,null,uid,null,0 );
        return bookCommentDao.deleteComment(bookComment);
    }
}
