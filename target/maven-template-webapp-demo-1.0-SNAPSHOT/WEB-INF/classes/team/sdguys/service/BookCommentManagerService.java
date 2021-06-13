package team.sdguys.service;

public interface BookCommentManagerService {

    /**
     * 根据Bid和Uid删除评论
     * @param bid 图书id uid 用户id
     * @return 影响的行数
     */
    public int deleteBookCommentByBidAndUid(int bid,int uid);
}
