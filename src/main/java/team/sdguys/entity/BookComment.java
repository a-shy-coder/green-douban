package team.sdguys.entity;

import java.util.Date;

/**
 * 图书评论实体类
 */
public class BookComment {

    // 书籍评论编号
    private int bcId;
    // 评论的哪部书
    private int bId;
    // 评论内容
    private String bcContent;
    // 评论用户id
    private int uId;
    // 评论发布时间
    private Date bcTime;
    // 点赞数量
    private int bcLikeCount;

    // 构造器
    public BookComment(int bcId, int bId, String bcContent, int uId, Date bcTime, int bcLikeCount) {
        this.bcId = bcId;
        this.bId = bId;
        this.bcContent = bcContent;
        this.uId = uId;
        this.bcTime = bcTime;
        this.bcLikeCount = bcLikeCount;
    }

    public BookComment(int bId, String bcContent, int uId, Date bcTime, int bcLikeCount) {
        this.bId = bId;
        this.bcContent = bcContent;
        this.uId = uId;
        this.bcTime = bcTime;
        this.bcLikeCount = bcLikeCount;
    }

    // getter setter
    public int getBcId() {
        return bcId;
    }

    public void setBcId(int bcId) {
        this.bcId = bcId;
    }

    public int getBId() {
        return bId;
    }

    public void setBId(int bId) {
        this.bId = bId;
    }

    public String getBcContent() {
        return bcContent;
    }

    public void setBcContent(String bcContent) {
        this.bcContent = bcContent;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public Date getBcTime() {
        return bcTime;
    }

    public void setBcTime(Date bcTime) {
        this.bcTime = bcTime;
    }

    public int getBcLikeCount() {
        return bcLikeCount;
    }

    public void setBcLikeCount(int bcLikeCount) {
        this.bcLikeCount = bcLikeCount;
    }
}


