package team.sdguys.service;

import team.sdguys.entity.BookReply;

import java.util.List;

/**
 * 图书回复逻业务逻辑的接口
 */
public interface BookReplyService {


    /**
     * 更新图书回复点赞数量
     * @param bookReplyId 图书回复编号
     * @param i 增加的点赞数量
     */
    void updateLikeCountByBookReplyId(int bookReplyId, int i);

    /**
     * 根据评论编号查找所有的回复
     * @param bcId 评论编号
     * @return 图书回复列表
     */
    List<BookReply> getBookReplyListByBookCommentId(int bcId);

    /**
     * 提交图书回复
     * @param bookReply 图书回复
     * @return 图书回复编号
     */
    int submitBookReply(BookReply bookReply);
}
