package team.sdguys.entity;

import java.util.Date;

/**
 * 日志回复实体类
 */
public class DiaryReply {
    //回复编号
    private int DRId;
    //发布回复的人
    private int DRFromId;
    // 回复的目标
    private int DRToId;
    // 回复内容
    private String DRContent;
    // 回复时间
    private Date DRTime;
    // 日志的编号
    private int DId;
    // 评论编号
    private int DCId;
    // 点赞数量
    private int DRLikeCount;

    public DiaryReply(int DRId,int DRFromId,int DRToId,String DRContent,Date DRTime,int DId,int DCId,int DRLikeCount){
        this.DRId = DRId;
        this.DRFromId = DRFromId;
        this.DRTime = DRTime;
        this.DRToId = DRToId;
        this.DRContent = DRContent;
        this.DId = DId;
        this.DCId = DCId;
        this.DRLikeCount = DRLikeCount;
    }
    public DiaryReply(int DRFromId,int DRToId,String DRContent,Date DRTime,int DId,int DCId,int DRLikeCount){
        this.DRFromId = DRFromId;
        this.DRTime = DRTime;
        this.DRToId = DRToId;
        this.DRContent = DRContent;
        this.DId = DId;
        this.DCId = DCId;
        this.DRLikeCount = DRLikeCount;
    }

    public int getDRId() {
        return DRId;
    }

    public void setDRId(int DRId) {
        this.DRId = DRId;
    }

    public int getDRFromId() {
        return DRFromId;
    }

    public void setDRFromId(int DRFromId) {
        this.DRFromId = DRFromId;
    }

    public int getDRToId() {
        return DRToId;
    }

    public void setDRToId(int DRToId) {
        this.DRToId = DRToId;
    }

    public String getDRContent() {
        return DRContent;
    }

    public void setDRContent(String DRContent) {
        this.DRContent = DRContent;
    }

    public Date getDRTime() {
        return DRTime;
    }

    public void setDRTime(Date DRTime) {
        this.DRTime = DRTime;
    }

    public int getDId() {
        return DId;
    }

    public void setDId(int DId) {
        this.DId = DId;
    }

    public int getDCId() {
        return DCId;
    }

    public void setDCId(int DCId) {
        this.DCId = DCId;
    }

    public int getDRLikeCount() {
        return DRLikeCount;
    }

    public void setDRLikeCount(int DRLikeCount) {
        this.DRLikeCount = DRLikeCount;
    }
}
