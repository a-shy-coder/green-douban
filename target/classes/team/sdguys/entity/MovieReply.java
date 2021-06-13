package team.sdguys.entity;

import java.util.Date;

/**
 * 电影回复实体类
 */
public class MovieReply {
    // 电影回复编号
    private int MRId;
    // 写回复的人
    private int MRFromId;
    // 回复的人
    private int MRToId;
    // 回复内容
    private String MRContent;
    // 回复时间
    private Date MRTime;
    // 电影编号
    private int MId;
    // 电影评论编号
    private int MCId;
    // 电影点赞数量
    private int MRLikeCount;

    public MovieReply(int MRId,int MRFromId,int MRToId,String MRContent,Date MRTime,int MId,int MCId,int MRLikeCount){
        this.MRId = MRId;
        this.MRFromId = MRFromId;
        this.MRToId = MRToId;
        this.MRContent = MRContent;
        this.MRTime = MRTime;
        this.MId = MId;
        this.MCId = MCId;
        this.MRLikeCount = MRLikeCount;

    }
    public MovieReply(int MRFromId,int MRToId,String MRContent,Date MRTime,int MId,int MCId,int MRLikeCount){
        this.MRFromId = MRFromId;
        this.MRToId = MRToId;
        this.MRContent = MRContent;
        this.MRTime = MRTime;
        this.MId = MId;
        this.MCId = MCId;
        this.MRLikeCount = MRLikeCount;

    }

    public int getMRId() {
        return MRId;
    }

    public void setMRId(int MRId) {
        this.MRId = MRId;
    }

    public int getMRFromId() {
        return MRFromId;
    }

    public void setMRFromId(int MRFromId) {
        this.MRFromId = MRFromId;
    }

    public int getMRToId() {
        return MRToId;
    }

    public void setMRToId(int MRToId) {
        this.MRToId = MRToId;
    }

    public String getMRContent() {
        return MRContent;
    }

    public void setMRContent(String MRContent) {
        this.MRContent = MRContent;
    }

    public Date getMRTime() {
        return MRTime;
    }

    public void setMRTime(Date MRTime) {
        this.MRTime = MRTime;
    }

    public int getMId() {
        return MId;
    }

    public void setMId(int MId) {
        this.MId = MId;
    }

    public int getMCId() {
        return MCId;
    }

    public void setMCId(int MCId) {
        this.MCId = MCId;
    }

    public int getMRLikeCount() {
        return MRLikeCount;
    }

    public void setMRLikeCount(int MRLikeCount) {
        this.MRLikeCount = MRLikeCount;
    }
}
