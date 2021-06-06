package team.sdguys.service;

import team.sdguys.entity.MovieComment;

import java.util.List;

/**
 * 电影评论相关业务
 */
public interface MovieCommentService {
    /**
     * 根据电影编号找到相关评论
     * @param movieId 电影编号
     * @return 电影评论列表
     */
    public List<MovieComment> findMovieCommentListByMovieId(int movieId);

    /**
     * 提交电影评论
     * @param movieComment 电影评论
     * @return 受影响的行数
     */
    public int submitMovieComment(MovieComment movieComment);
}
