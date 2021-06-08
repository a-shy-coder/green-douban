package team.sdguys.service;

/**
 * 电影回复的逻辑业务接口
 */
public interface MoiveReplyService {
    /**
     * 更新电影回复点赞数量
     * @param movieReplyId 电影回复编号
     * @param i 增加的点赞数量
     */
    void updateLikeCountByMovieReplyId(int movieReplyId, int i);
}
