package team.sdguys.entity;

import java.util.Date;

/**
 * 电影评论实体类
 */
public class MovieComment {
    // 电影评论编号
    private int MCId;
    //电影编号
    private int MId;
    // 电影评论内容
    private String MCcontent;
    // 用户编号
    private int UId;
    // 电影评论时间
    private Date MCTime;
    // 电影评论点赞数量
    private int MCLikeCount;

    public MovieComment(int MCId,int MId,String MCcontent,int UId,Date MCTime,int MCLikeCount){
        this.MCId = MCId;
        this.MId = MId;
        this.MCcontent = MCcontent;
        this.UId = UId;
        this.MCTime = MCTime;
        this.MCLikeCount = MCLikeCount;
    }
    public MovieComment(int MId,String MCcontent,int UId,Date MCTime,int MCLikeCount){
        this.MId = MId;
        this.MCcontent = MCcontent;
        this.UId = UId;
        this.MCTime = MCTime;
        this.MCLikeCount = MCLikeCount;
    }

    public int getMCId() {
        return MCId;
    }

    public void setMCId(int MCId) {
        this.MCId = MCId;
    }

    public int getMId() {
        return MId;
    }

    public void setMId(int MId) {
        this.MId = MId;
    }

    public String getMCcontent() {
        return MCcontent;
    }

    public void setMCcontent(String MCcontent) {
        this.MCcontent = MCcontent;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public Date getMCTime() {
        return MCTime;
    }

    public void setMCTime(Date MCTime) {
        this.MCTime = MCTime;
    }

    public int getMCLikeCount() {
        return MCLikeCount;
    }

    public void setMCLikeCount(int MCLikeCount) {
        this.MCLikeCount = MCLikeCount;
    }
}
