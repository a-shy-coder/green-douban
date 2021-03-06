package team.sdguys.entity;

import java.util.Date;

/**
 * 日志实体类
 */
public class Diary {
    // 日志编号
    private int DiaryId;
    // 日志标题
    private String DiaryTitle;
    // 日志内容
    private String DiaryContent;
    // 日志发布时间
    private Date DiaryTime;
    // 发布日志用户
    private int UId;
    // 日志点赞数量
    private int DLikeCount;


    public Diary() {
    }

    public Diary(int diaryId, String diaryTitle, String diaryContent, Date diaryTime, int UId, int DLikeCount) {
        DiaryId = diaryId;
        DiaryTitle = diaryTitle;
        DiaryContent = diaryContent;
        DiaryTime = diaryTime;
        this.UId = UId;
        this.DLikeCount = DLikeCount;
    }

    public Diary(String diaryTitle, String diaryContent, Date diaryTime, int UId, int DLikeCount) {
        DiaryTitle = diaryTitle;
        DiaryContent = diaryContent;
        DiaryTime = diaryTime;
        this.UId = UId;
        this.DLikeCount = DLikeCount;
    }

    public int getDiaryId() {
        return DiaryId;
    }

    public void setDiaryId(int diaryId) {
        DiaryId = diaryId;
    }

    public String getDiaryTitle() {
        return DiaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        DiaryTitle = diaryTitle;
    }

    public String getDiaryContent() {
        return DiaryContent;
    }

    public void setDiaryContent(String diaryContent) {
        DiaryContent = diaryContent;
    }

    public Date getDiaryTime() {
        return DiaryTime;
    }

    public void setDiaryTime(Date diaryTime) {
        DiaryTime = diaryTime;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public int getDLikeCount() {
        return DLikeCount;
    }

    public void setDLikeCount(int DLikeCount) {
        this.DLikeCount = DLikeCount;
    }
}
