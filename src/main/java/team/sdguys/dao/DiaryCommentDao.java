package team.sdguys.dao;

import team.sdguys.entity.DiaryComment;

import java.util.List;

public interface DiaryCommentDao extends BaseDao{
    /**
     *根据did查找dcidlist
     * @param did
     */
    List<Integer> getdcidlistbydid(int did);

    /**
     * 根据dcidlist检索所有dc
     * @param list
     */
    List<DiaryComment> getDClistbydcidlist(List<Integer> list);

    /**
     * 根据uid检索Diarycomment
     * @param uid
     * @return list
     */
    List<Integer> getdcidbyuid(int uid);

    /**
     * 添加一条评论
     * @return 受影响的行数
     */
    int InsertDiaryComment(DiaryComment diaryComment);
    /**
     * 更新一个新日志评论
     */
    public int updateDiaryComment(String dcContent,int uid,int dcid);

    /**
     * 删除一个新日志评论
     */
    public int deleteDiaryComment(int dcid,int uid);

    /**
     * 点赞
     */
    int addoneDCLikeCount(int DCId);

    /**
     * 取消点赞
     */
    int suboneDCLikeCount(int DCId);

    /**
     * 通过日志编号获取日志评论列表
     * @param diaryId 日志编号
     * @return 日志评论列表
     */
    List<DiaryComment> getDiaryCommentListByDiaryId(int diaryId);

    /**
     * 更新评论点赞数量
     * @param diaryCommentId 评论编号
     * @param i 增加的点赞数量
     */
    void updateLikeCountByDiaryCommentId(int diaryCommentId, int i);

    /**
     * 根据评论编号查找评论
     * @param dcId 编号
     * @return 评论
     */
    DiaryComment getDiaryCommentByDiaryCommentId(int dcId);

    /**
     * 根据uid查找该用户的所有评论
     * @param uid 用户编号
     * @return 评论列表
     */
    List<DiaryComment> getDiaryCommentListByUid(int uid);
}
