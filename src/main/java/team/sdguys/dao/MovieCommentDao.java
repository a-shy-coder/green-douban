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
}
