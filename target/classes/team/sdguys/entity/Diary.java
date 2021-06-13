package team.sdguys.entity;

import java.util.Date;

/**
 * 日志实体类
 */
public class Diary {
    // 日志编号
    private int DiaryId;
    // 日志内容
    private String DiaryContent;
    // 日志发布时间
    private Date DiaryTime;
    // 发布日志用户
    private int UId;
    // 日志点赞数量
    private int DLikeCount;

    public Diary(int DiaryId,String DiaryContent,Date DiaryTime,int UId,int DLikeCount){
        this.DiaryId = DiaryId;
        this.DiaryContent = DiaryContent;
        this.DiaryTime = DiaryTime;
        this.UId = UId;
        this.DLikeCount = DLikeCount;

    }

    public Diary(String DiaryContent,Date DiaryTime,int UId,int DLikeCount){
        this.DiaryContent = DiaryContent;
        this.DiaryTime = DiaryTime;
        this.UId = UId;
        this.DLikeCount = DLikeCount;

    }

    public int getDiaryId() {
        return DiaryId;
    }

    public void setDiaryId(int diaryId) {
        DiaryId = diaryId;
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
