package team.sdguys.service;

import team.sdguys.entity.DiaryComment;

import java.util.List;

public interface DiaryCommentService {
    /**
     * 根据did查找dcidlist
     * @param did
     */
    public List<Integer> getdcidlistbydid(int did);

    /**
     * 根据dcidlist检索所有的dc
     * @param list
     */
    public List<DiaryComment> getDClistbydcidlist(List<Integer> list);

    /**
     *
     */
    public List<Integer> getdcidbyuid(int uid);

    /**
     * 插入一个新日志评论
     */
    public int insertnewDiaryComment(DiaryComment diaryComment);

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
    public int addoneDCLikeCount(int DCId);

    /**
     * 取消点赞
     */
    public int suboneDCLikeCount(int DCId);


    /**
     * 通过日志编号获取日志评论列表
     * @param diaryId 日志编号
     * @return 日志评论列表
     */
    List<DiaryComment> getDiaryCommentListByDiaryId(int diaryId);

    /**
     * 插入一条日志评论
     * @param diaryComment 日志评论
     * @return 受影响的行数
     */
    int submitDiaryComment(DiaryComment diaryComment);
    
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
    DiaryComment findDiaryCommentByDiaryCommentId(int dcId);

    /**
     * 根据uid查找该用户的所有评论
     * @param uid 用户编号
     * @return 评论列表
     */
    List<DiaryComment> findDiaryCommentListByUid(int uid);
}
