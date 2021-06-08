package team.sdguys.service;

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
}
