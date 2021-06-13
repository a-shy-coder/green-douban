package team.sdguys.entity;

import java.util.Date;

/**
 * 日志评论实体类
 */
public class DiaryComment {
    // 日志评论编号
    private int dCid;
    // 日志编号
    private int did;
    // 日志评论内容
    private String dCContent;
    // 发布评论编号
    private int Uid;
    // 评论发布时间
    private Date dCTime;
    // 评论点赞数量
    private int dCLikeCount;

    public DiaryComment(int dCid, int did, String dCContent, int uid, Date dCTime, int dCLikeCount) {
        this.dCid = dCid;
        this.did = did;
        this.dCContent = dCContent;
        Uid = uid;
        this.dCTime = dCTime;
        this.dCLikeCount = dCLikeCount;
    }

    public DiaryComment(int did, String dCContent, int uid, Date dCTime, int dCLikeCount) {
        this.did = did;
        this.dCContent = dCContent;
        Uid = uid;
        this.dCTime = dCTime;
        this.dCLikeCount = dCLikeCount;
    }

    public int getdCid() {
        return dCid;
    }

    public void setdCid(int dCid) {
        this.dCid = dCid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getdCContent() {
        return dCContent;
    }

    public void setdCContent(String dCContent) {
        this.dCContent = dCContent;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public Date getdCTime() {
        return dCTime;
    }

    public void setdCTime(Date dCTime) {
        this.dCTime = dCTime;
    }

    public int getdCLikeCount() {
        return dCLikeCount;
    }

    public void setdCLikeCount(int dCLikeCount) {
        this.dCLikeCount = dCLikeCount;
    }
}
