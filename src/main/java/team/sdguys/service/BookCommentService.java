package team.sdguys.service;

import team.sdguys.entity.BookComment;
import team.sdguys.entity.MovieComment;

import java.util.List;

/**
 * 图书评论业务接口
 */
public interface BookCommentService {
    /**
     * 根据图书编号找到相关评论
     * @param bookId 电影编号
     * @return 图书评论列表
     */
    public List<BookComment> findBookCommentListByBookId(int bookId);

    /**
     * 插入一条图书评论
     * @param bookComment 图书评论
     * @return 受影响的行数
     */
    public int submitBookComment(BookComment bookComment);


    /**
     * 删除一条评论
     *
     * @param bcid,uid;
     * @return 修改的行数
     */
    public int deleteComment(int bcid, int uid);

    /**
     * 更改一条评论
     *
     * @param bcid,uid;
     * @return linenumber
     */
    public int updateComment(int bcid, int uid, String content);

    /**
     * 更新图书评论点赞数量
     * @param bookCommentId 图书评论编号
     * @param i 增加的点赞数量
     */
    void updateLikeCountByBookCommentId(int bookCommentId, int i);
}
