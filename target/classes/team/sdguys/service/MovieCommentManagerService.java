package team.sdguys.service;

public interface MovieCommentManagerService {

    /**
     * 根据Mid和Uid删除评论
     * @param mid 电影id uid 用户id
     * @return 影响的行数
     */
    public int deleteMovieCommentByMidAndUid(int mid,int uid);

}
