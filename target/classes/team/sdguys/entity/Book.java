package team.sdguys.entity;
import java.util.Date;

/**
 * Book实体类
 */
public class Book {
    // 图书编号(自动增长)
    private int BId;
    // 图书中文名称
    private String BChineseName;
    // 图书原名
    private String BOriginName;
    // 图书类型
    private String BType;
    // 图书评分
    private float BRating;
    // 图书评分个数
    private int BRatingCount;
    // 图书发行日期
    private Date BReleaseDate;
    // 图书出版商
    private String BPublisher;
    // 作者编号
    private int AuthorId;
    // 图书页数
    private int bPageCount;
    // 图书装帧
    private String bBinding;
    // 图书简介
    private String bContent;
    // 图书语言
    private String bLanguage;
    // 图书封面
    private String bCover;


    // 构造器
    public Book(int BId, String BChineseName, String BOriginName, String BType, float BRating, int BRatingCount, Date BReleaseDate, String BPublisher, int authorId, int bPageCount, String bBinding, String bContent, String bLanguage, String bCover) {
        this.BId = BId;
        this.BChineseName = BChineseName;
        this.BOriginName = BOriginName;
        this.BType = BType;
        this.BRating = BRating;
        this.BRatingCount = BRatingCount;
        this.BReleaseDate = BReleaseDate;
        this.BPublisher = BPublisher;
        AuthorId = authorId;
        this.bPageCount = bPageCount;
        this.bBinding = bBinding;
        this.bContent = bContent;
        this.bLanguage = bLanguage;
        this.bCover = bCover;
    }

    public Book(String BChineseName, String BOriginName, String BType, float BRating, int BRatingCount, Date BReleaseDate, String BPublisher, int authorId, int bPageCount, String bBinding, String bContent, String bLanguage, String bCover) {
        this.BChineseName = BChineseName;
        this.BOriginName = BOriginName;
        this.BType = BType;
        this.BRating = BRating;
        this.BRatingCount = BRatingCount;
        this.BReleaseDate = BReleaseDate;
        this.BPublisher = BPublisher;
        AuthorId = authorId;
        this.bPageCount = bPageCount;
        this.bBinding = bBinding;
        this.bContent = bContent;
        this.bLanguage = bLanguage;
        this.bCover = bCover;
    }

    public Book(String BChineseName, String BOriginName, String BType, float BRating, int BRatingCount, Date BReleaseDate, String BPublisher, int bPageCount, String bBinding, String bContent, String bLanguage, String bCover) {
        this.BChineseName = BChineseName;
        this.BOriginName = BOriginName;
        this.BType = BType;
        this.BRating = BRating;
        this.BRatingCount = BRatingCount;
        this.BReleaseDate = BReleaseDate;
        this.BPublisher = BPublisher;
        this.bPageCount = bPageCount;
        this.bBinding = bBinding;
        this.bContent = bContent;
        this.bLanguage = bLanguage;
        this.bCover = bCover;
    }

    // getter setter
    public int getBId() {
        return BId;
    }

    public void setBId(int BId) {
        this.BId = BId;
    }

    public String getBChineseName() {
        return BChineseName;
    }

    public void setBChineseName(String BChineseName) {
        this.BChineseName = BChineseName;
    }

    public String getBOriginName() {
        return BOriginName;
    }

    public void setBOriginName(String BOriginName) {
        this.BOriginName = BOriginName;
    }

    public String getBType() {
        return BType;
    }

    public void setBType(String BType) {
        this.BType = BType;
    }

    public float getBRating() {
        return BRating;
    }

    public void setBRating(float BRating) {
        this.BRating = BRating;
    }

    public int getBRatingCount() {
        return BRatingCount;
    }

    public void setBRatingCount(int BRatingCount) {
        this.BRatingCount = BRatingCount;
    }

    public Date getBReleaseDate() {
        return BReleaseDate;
    }

    public void setBReleaseDate(Date BReleaseDate) {
        this.BReleaseDate = BReleaseDate;
    }

    public String getBPublisher() {
        return BPublisher;
    }

    public void setBPublisher(String BPublisher) {
        this.BPublisher = BPublisher;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public int getbPageCount() {
        return bPageCount;
    }

    public void setbPageCount(int bPageCount) {
        this.bPageCount = bPageCount;
    }

    public String getbBinding() {
        return bBinding;
    }

    public void setbBinding(String bBinding) {
        this.bBinding = bBinding;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public String getbLanguage() {
        return bLanguage;
    }

    public void setbLanguage(String bLanguage) {
        this.bLanguage = bLanguage;
    }

    public String getbCover() {
        return bCover;
    }

    public void setbCover(String bCover) {
        this.bCover = bCover;
    }
}
