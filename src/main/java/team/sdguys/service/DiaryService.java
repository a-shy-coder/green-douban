package team.sdguys.service;

import team.sdguys.entity.Diary;

import java.util.List;

public interface DiaryService {
    /**
     * 新建一条日志
     * @return 受影响的行数
     */
    public int insertNewDiary(Diary diary);

    /**
     * 更新一条日志
     * @return 受影响的行数
     */
    public int updateDiary(int DiaryId, String DiaryContent);

    /**
     * 删除一条日志
     * @return  受影响的行数
     */
    public int deleteDiary(int DiaryId);

    /**
     * 增加一个点赞数
     * @return 受影响的行数
     */
    public int addoneDLikeCount(int DiaryId);

    /**
     * 取消一个点赞数
     * @return 受影响的行数
     */
    public int suboneDLikeCount(int DiaryId);

    /**
     * 按点赞数量降序排序日志DiaryId
     * @return DiaryId列表
     *
     */
    public List<Integer> getDiaryIdListByDlikeCount();

    /**
     * 按时间降序排序日至DiaryId
     * @return DiaryId列表
     */
    public List<Integer> getDiaryIdListByDiaryTime(int uid);

    /**
     * 筛选热度前五的日志
     * @return DiaryId列表
     */
    public List<Integer> getTop5DiaryId(int uid);

    /**
     *
     */
    public  List<Diary> getdiarybylist(List<Integer> list);
    /**
     * 根据DiaryId检索日志的所有信息
     * @param did
     * @return diary
     */
    public Diary getallbyDiaryId(int did);

    /**
     * 根据uid查找该用户的所有日志
     * @param uid 用户编号
     * @return 日志列表
     */
    List<Diary> getDiaryListByUid(int uid);
}
