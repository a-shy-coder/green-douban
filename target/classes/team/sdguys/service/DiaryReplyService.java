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




}
