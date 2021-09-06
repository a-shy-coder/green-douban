package team.sdguys.dao;
import team.sdguys.entity.Diary;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface DiaryDao extends BaseDao{
    /**
     * 根据DiaryId检索日志的所有信息
     * @param DiaryId
     * @return diary
     */
    Diary getallbyDiaryId(int DiaryId);

    /**
     * 根据DiaryId检索日志内容DiaryContent
     * @param DiaryId
     * @return DiaryContent
     */
    String getDiaryContentbyDiaryId(int DiaryId);

    /**
     * 根据DiaryId检索DiaryTime日志发布时间
     * @param DiaryId
     * @return DiaryTime
     */
    Date getDiaryTimebyDiaryId(int DiaryId);

    /**
     * 根据DiaryId检索UId
     * @param DiaryId
     * @return UId
     */
    int getUIdbyDiaryId(int DiaryId);

    /**
     * 根据DiaryId检索DLikeCount日志点赞数
     * @param DiaryId
     * @return DLikeCount
     */
    int getDLikeCountbyDiaryId(int DiaryId);

    /**
     * 根据UId检索其发布的所有日志的DiaryId
     * @param UId
     * @return DiaryId列表
     */
    List<Integer> getownDiaryIdbyUId(int UId);

    /**
     * 新建一条日志
     * @return 受影响的行数
     */
    int insertNewDiary(Diary diary);

    /**
     * 更新一条日志
     * @return 受影响的行数
     */
    int updateDiary(int DiaryId, String DiaryContent);

    /**
     * 删除一条日志
     * @return  受影响的行数
     */
    int deleteDiary(int DiaryId);

    /**
     * 增加一个点赞数
     * @return 受影响的行数
     */
    int addoneDLikeCount(Diary diary);

    /**
     * 取消一个点赞数
     * @return 受影响的行数
     */
    int suboneDLikeCount(Diary diary);

    /**
     * 按点赞数量降序排序日志DiaryId
     * @return DiaryId列表
     *
     */
    List<Integer> getDiaryIdListByDlikeCount();

    /**
     * 按时间降序排序日至DiaryId
     * @return DiaryId列表
     */
    List<Integer> getDiaryIdListByDiaryTime();

    /**
     * 筛选热度前五的日志
     * @return DiaryId列表
     */
    List<Integer> getTop5DiaryId();

    /**
     * 根据uid查找该用户的所有日志
     * @param uid 用户编号
     * @return 日志列表
     */
    List<Diary> getDiaryListByUid(int uid);

    /**
     * @description TODO 首页的日志精选，按照时间的降序显示日志列表
     * @return 十条日志
     * */
    List<Diary> getDiaryOrderByTimeDesc() throws SQLException;
}
