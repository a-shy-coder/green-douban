package team.sdguys.service;

import team.sdguys.entity.DiaryReply;

import java.util.List;

public interface DiaryReplyService {

    /**
     *根据dcid查找drid
     * @param list
     * @return drid
     */
    public List<Integer> getDridlistbyDCId(List<Integer> list);

    /**
     * 根据drid查找dr
     * @param dridlist
     * @return DR
     */
    public List<DiaryReply> getDiaryReplybydrid(List<Integer> dridlist);

    /**
     * 根据uid查找drid
     */
    public  List<Integer> getDridListbyuid(int uid);


    /***
     * 点赞
     */
    public int addoneDrLikeCount(int drid);

    /**
     * 取消点赞
     */
    public int deleteoneDrLikeCount(int drid);

    /**
     * 新增一个日志回复
     */
    public int addoneDiaryReply(DiaryReply diaryReply);

    /**
     * 删除一个日志回复
     */
    public int deleteoneDiaryReply(int Drid,int uid);


    /**
     * 更新回复点赞数量
     * @param diaryReplyId 回复编号
     * @param i 增加的点赞数量
     */
    void updateLikeCountByDiaryReplyId(int diaryReplyId, int i);

    /**
     * 根据评论编号查找所有的回复
     * @param dcId 评论编号
     * @return 电影回复列表
     */
    List<DiaryReply> getDiaryReplyListByDiaryCommentId(int dcId);

    /**
     * 提交回复
     * @param diaryReply 回复
     * @return 回复编号
     */
    int submitDiaryReply(DiaryReply diaryReply);

    /**
     * 根据uid查找该用户的所有回复
     * @param uid 用户编号
     * @return 评论列表
     */
    List<DiaryReply> findDiaryReplyListByUid(int uid);

    /**
     * 根据回复编号删除回复
     * @param diaryReplyId 回复编号
     * @return 受影响的行数
     */
    int deleteDiaryReplyByDiaryReplyId(int diaryReplyId);
}
