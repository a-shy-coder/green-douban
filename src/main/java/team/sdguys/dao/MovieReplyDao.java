package team.sdguys.dao;

import team.sdguys.entity.MovieReply;

import java.util.List;

/**
 * 电影回复表的Dao层
 */
public interface MovieReplyDao {

    /**
     * 根据评论编号查找所有的回复
     * @param mcId 评论编号
     * @return 电影回复列表
     */
    public List<MovieReply> getMovieReplyListByMovieCommentId(int mcId);

    /**
     * 插入一条电影回复
     * @param movieReply 电影回复
     * @return 电影回复ID
     */
    int insertMovieReply(MovieReply movieReply);
}
