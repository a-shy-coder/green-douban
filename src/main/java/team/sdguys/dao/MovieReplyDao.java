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

    /**
     * 更新电影回复点赞数量
     * @param movieReplyId 电影回复编号
     * @param i 增加的点赞数量 1代表增加1 -1代表减少1 直接 +=i 即可
     * @return
     */
    int updateLikeCountByMovieReplyId(int movieReplyId, int i);
}
