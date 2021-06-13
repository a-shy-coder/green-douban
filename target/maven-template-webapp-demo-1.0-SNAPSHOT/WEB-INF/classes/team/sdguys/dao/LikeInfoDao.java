package team.sdguys.dao;

import team.sdguys.entity.LikeInfo;

import java.util.List;

/**
 * LikeInfo表的Dao层
 */
public interface LikeInfoDao extends BaseDao{
    /**
     * 插入一条点赞信息
     * @param likeInfo 点赞信息
     * @return 受影响的行数
     */
    int insertLikeInfo(LikeInfo likeInfo);

    /**
     * 删除一条点赞信息
     * @param uid 用户编号
     * @param likeId 编号
     * @param type 类型
     * @return
     */
    int deleteLikeInfoByUidAndLikeIdAndType(int uid, int likeId, int type);

    /**
     * 找到用户已经点赞过的评论/回复ID列表
     * @param uid 用户编号
     * @param type 类型
     * @return ID列表
     */
    List<Integer> findLikeIdListByUidAndType(int uid, int type);
}
