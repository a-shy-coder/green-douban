package team.sdguys.dao;

import team.sdguys.entity.MovieComment;

import java.util.List;

/**
 * 电影评论表的Dao层
 */
public interface MovieCommentDao extends BaseDao {

    /**
     * 根据电影编号找到相关评论
     * @param movieId 电影编号
     * @return 电影评论列表
     */
    public List<MovieComment> getMovieCommentListByMovieId(int movieId);

    /**
     * 插入一条电影评论
     * @param movieComment 电影评论
     * @return 电影评论ID
     */
    public int insertMovieComment(MovieComment movieComment);

    /**
     * 删除一条评论
     * @param mcid 评论编号
     * @return 修改的行数
     */
    int deleteComment(int mcid);

    /**
     * 更改一条评论
     * @param mcid,uid;
     * @return linenumber
     */
    int updateComment(int mcid,int uid,String content);

    /**
     * 删除一条评论
     * @param movieComment
     * @return 修改的行数
     */
    int deleteComment(MovieComment movieComment);

    /**
     * 获取一条评论
     * @param mcId 评论编号
     * @return 评论
     */
    MovieComment getMovieCommentByMovieCommentId(int mcId);

    /**
     * 更新电影评论点赞数量
     * @param movieCommentId 电影评论编号
     * @param i 增加的点赞数量 1代表增加1 -1代表减少1 直接 +=i 即可
     * @return
     */
    int updateLikeCountByMovieCommentId(int movieCommentId, int i);

    /**
     * 根据uid查找该用户的所有评论
     * @param uid 用户编号
     * @return 评论列表
     */
    List<MovieComment> getMovieCommentListByUid(int uid);
}
