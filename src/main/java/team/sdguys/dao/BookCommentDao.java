package team.sdguys.dao;
import team.sdguys.entity.BookComment;
import team.sdguys.entity.MovieComment;

import java.util.List;

/**
 * 图书评论表的Dao层
 */
public interface BookCommentDao extends BaseDao{

    /**
     * 根据BCId检索评论
     * @param bcId 评论编号
     * @return bookcomment 图书评论实体类
     */
    BookComment getBookCommentByBCId(int bcId);



    /**
     * 增加一条评论
     * @param bookComment
     * @return 修改的行数
     */
    int insertComment(BookComment bookComment);

    /**
     * 删除一条评论
     * @param bcid,uid
     * @return 修改的行数
     */
    int deleteComment(int bcid,int uid);

    /**
     * 删除一条评论
     * @param bookComment
     * @return 修改的行数
     */
    int deleteComment(BookComment bookComment);

    /**更改一条评论
     * @param bcid,uid;
     * @return linenumber
     */
    int updateComment(int bcid,int uid,String content);

    /**
     * 显示高赞评论BCId
     * @return List<Integer> BCId的列表
     */
    List<Integer> getTop5BookCommentsList();



    /**
     * 获取该评论的点赞数量
     * @param BCId 图书编号
     * @return 点赞数量
     */
    int getBLikeCountByBCId(int BCId);

    /**
     * 更新该评论的点赞数量
     * @param BCId 图书编号
     * @param BLikeCount 点赞数量
     * @return 受影响的行数
     */
    int updateBLikeCountByBCId(int BCId, int BLikeCount);

    /**
     * 根据图书编号找到相关评论
     * @param bookId 电影编号
     * @return 图书评论列表
     */
    List<BookComment> getBookCommentListByBookId(int bookId);

    /**
     * 插入一条图书评论
     * @param bookComment 图书评论
     * @return 受影响的行数
     */
    int insertBookComment(BookComment bookComment);

}
