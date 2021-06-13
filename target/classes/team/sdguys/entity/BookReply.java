package team.sdguys.entity;

import java.util.Date;

/**
 * 书籍回复表
 */
public class BookReply {
    //回复编号
    private int BRId;
    //发布回复的人
    private int BRFromId;
    //回复目标
    private int BRToId;
    //回复内容
    private String BRContent;
    //回复时间
    private Date BRTime;
    //关于哪部书籍的回复
    private int BId;
    //评论的编号
    private int BCId;
    //点赞数量
    private int BRLikeCount;

    public BookReply() {
    }

    public BookReply(int BRId,int BRFromId,int BRToId,String BRContent,Date BRTime,int BId,int BCId,int BRLikeCount){
        this.BRId = BRId;
        this.BRFromId = BRFromId;
        this.BRToId = BRToId;
        this.BRContent = BRContent;
        this.BRTime = BRTime;
        this.BId = BId;
        this.BCId = BCId;
        this.BRLikeCount = BRLikeCount;
    }

    public BookReply(int BRFromId,int BRToId,String BRContent,Date BRTime,int BId,int BCId,int BRLikeCount){
        this.BRFromId = BRFromId;
        this.BRToId = BRToId;
        this.BRContent = BRContent;
        this.BRTime = BRTime;
        this.BId = BId;
        this.BCId = BCId;
        this.BRLikeCount = BRLikeCount;
    }

    public int getBRId() {
        return BRId;
    }

    public void setBRId(int BRId) {
        this.BRId = BRId;
    }

    public int getBRFromId() {
        return BRFromId;
    }

    public void setBRFromId(int BRFromId) {
        this.BRFromId = BRFromId;
    }

    public int getBRToId() {
        return BRToId;
    }

    public void setBRToId(int BRToId) {
        this.BRToId = BRToId;
    }

    public String getBRContent() {
        return BRContent;
    }

    public void setBRContent(String BRContent) {
        this.BRContent = BRContent;
    }

    public Date getBRTime() {
        return BRTime;
    }

    public void setBRTime(Date BRTime) {
        this.BRTime = BRTime;
    }

    public int getBId() {
        return BId;
    }

    public void setBId(int BId) {
        this.BId = BId;
    }

    public int getBCId() {
        return BCId;
    }

    public void setBCId(int BCId) {
        this.BCId = BCId;
    }

    public int getBRLikeCount() {
        return BRLikeCount;
    }

    public void setBRLikeCount(int BRLikeCount) {
        this.BRLikeCount = BRLikeCount;
    }
}
