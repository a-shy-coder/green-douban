package team.sdguys.dao;
import team.sdguys.entity.DiaryReply;

import java.util.Date;
import java.util.List;

public interface DiaryReplyDao extends BaseDao{
    /**
     *根据DRId查找回复的所有信息
     * @param dridlist
     * @return diaryReply
     */
    List<DiaryReply> getallbyDRId(List<Integer> dridlist);

    /**
     * 根据DRId检索DRFromId
     * @param DRId
     * @return DRFromId
     */
    int getDRFromIdbyDRId(int DRId);

    /**
     * 根据DRId检索DRToId
     * @param DRId
     * @return DRToId
     */
    int getDRToIdbyDRId(int DRId);

    /**
     * 根据DRId检索DRContent
     * @param  DRId
     * @return DRContent
     */
    String getDRContentbyDRId(int DRId);

    /**
     * 根据DRId检索DRTime
     * @param DRId
     * @return DRTime
     */
    Date getDRTimebyDRId(int DRId);

    /**
     * 根据DRId检索DId
     * @param DRId
     * @return DId
     */
    int getDIdbyDRId(int DRId);

    /**
     * 根据DRId检索DCId
     * @param DRId
     * @return DCId
     */
    int getDCIdbyDRId(int DRId);

    /**
     * 根据DRId检索DRLikeCount
     * @param  DRId
     * @return DRLikeCount
     */
    int getDRLikeCountbyDRId(int DRId);

    /**
     * 根据日志编号DID检索所有有关DRID
     * @param DId
     * @return DRId列表
     */
    List<Integer> getDRIdListbyDID(int DId);

    /**
     * 根据评论编号DCId检索所有有关的DId
     * @param list
     * @return DRId列表
     */
    List<Integer> getDRIdListbyDCId(List<Integer> list);

    /**
     * 根据DRFromId检索所有相关DRId
     * @param DRFromId
     * @return DRId列表
     */
    List<Integer> getDRIdListbyDRFromId(int DRFromId);

    /**
     * 根据DRToId检索所有相关DRId
     * @param DRToId
     * @return DRId列表
     */
    List<Integer> getDRIdListbyDRToId(int DRToId);

    /**
     * 按DRLikeCount排序检索全部DRId
     * @return DRId列表
     */
    List<Integer> getDRIdListbyDRLikeCount();

    /**
     * 按DRTime排序检索全部DRId
     * @return DRID列表
     */
    List<Integer> getDRIdListbyDRTime();

    /**
     * 筛选热度前五的回复DRId
     * @return DRId列表
     */
    List<Integer> getTop5BRId();

    /**
     * 增加一个点赞
     * @return 受影响的行数
     */
    int addoneDRLikeCount(int drid);

    /**
     * 取消一个点赞
     * @return 受影响的行数
     */
    int suboneDRLikeCount(int drid);

    /**
     * 新建一条回复
     * @return 受影响的行数
     */
    int insertDiaryReply(DiaryReply diaryReply);


    /**
     * 删除一条回复
     * @return 受影响的行数
     */
    int deleteDiaryReply(int Drid,int uid);


    /**
     * 根据uid查找drid
     */
    List<Integer> getDridListbyuid(int uid);

}
