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



}
