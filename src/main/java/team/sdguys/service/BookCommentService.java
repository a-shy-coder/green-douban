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
     * @param bcid;
     * @return 修改的行数
     */
    public int deleteComment(int bcid);

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

    /**
     * 根据评论编号查找评论
     * @param bcId 编号
     * @return 电影评论
     */
    BookComment findBookCommentByBookCommentId(int bcId);

    /**
     * 根据uid查找该用户的所有评论
     * @param uid 用户编号
     * @return 评论列表
     */
    List<BookComment> findBookCommentListByUid(int uid);
}
