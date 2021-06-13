package team.sdguys.service;

import team.sdguys.entity.MovieReply;

import java.util.List;

/**
 * 电影回复业务接口
 */
public interface MovieReplyService {

    /**
     * 根据评论编号查找所有的回复
     * @param mcId 评论编号
     * @return 电影回复列表
     */
    List<MovieReply> getMovieReplyListByMovieCommentId(int mcId);

    /**
     * 提交电影回复
     * @param movieReply 电影回复
     * @return 电影回复编号
     */
    int submitMovieReply(MovieReply movieReply);

    /**
     * 根据uid查找该用户的所有回复
     * @param uid 用户编号
     * @return 评论列表
     */
    List<MovieReply> findMovieReplyListByUid(int uid);
}
