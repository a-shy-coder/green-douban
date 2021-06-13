package team.sdguys.service;

import team.sdguys.entity.LikeInfo;

import java.util.List;

/**
 * 点赞业务逻辑接口
 */
public interface LikeInfoService {
    /**
     * 插入一条点赞信息
     * @param likeInfo 点赞信息
     */
    void insertLikeInfo(LikeInfo likeInfo);

    /**
     * 删除一条点赞信息
     * @param uid 用户编号
     * @param likeId 编号
     * @param type 类型
     */
    void deleteLikeInfoByUidAndLikeIdAndType(int uid, int likeId, int type);

    /**
     * 找到用户已经点赞过的评论/回复ID列表
     * @param uid 用户编号
     * @param type 类型
     * @return ID列表
     */
    List<Integer> findLikeIdListByUidAndType(int uid, int type);
}
