package team.sdguys.entity;

import java.util.Date;

/**
 * 电影实体类
 */
public class Movie {
    // 电影编号
    private int MovieId;
    // 电影中文名
    private String MChineseName;
    // 电影原名
    private String MOriginName;
    // 电影类型
    private String MType;
    // 电影评分
    private double MRating;
    // 电影评分数量
    private int MRatingCount;
    // 电影发行日期
    private Date MReleaseDate;
    // 导演编号
    private int DirectorId;
    // 电影语言
    private String mLanguage;
    // 电影市场
    private String mLength;
    // 拍摄国家/地区
    private String mArea;
    // 电影简介
    private String mContent;
    // 电影封面
    private String mCover;


    // 构造器
    public Movie(int movieId, String MChineseName, String MOriginName, String MType, double MRating, int MRatingCount, Date MReleaseDate, int directorId, String mLanguage, String mLength, String mArea, String mContent, String mCover) {
        MovieId = movieId;
        this.MChineseName = MChineseName;
        this.MOriginName = MOriginName;
        this.MType = MType;
        this.MRating = MRating;
        this.MRatingCount = MRatingCount;
        this.MReleaseDate = MReleaseDate;
        DirectorId = directorId;
        this.mLanguage = mLanguage;
        this.mLength = mLength;
        this.mArea = mArea;
        this.mContent = mContent;
        this.mCover = mCover;
    }

    public Movie(String MChineseName, String MOriginName, String MType, double MRating, int MRatingCount, Date MReleaseDate, int directorId, String mLanguage, String mLength, String mArea, String mContent, String mCover) {
        this.MChineseName = MChineseName;
        this.MOriginName = MOriginName;
        this.MType = MType;
        this.MRating = MRating;
        this.MRatingCount = MRatingCount;
        this.MReleaseDate = MReleaseDate;
        DirectorId = directorId;
        this.mLanguage = mLanguage;
        this.mLength = mLength;
        this.mArea = mArea;
        this.mContent = mContent;
        this.mCover = mCover;
    }

    // getter setter

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int movieId) {
        MovieId = movieId;
    }

    public String getMChineseName() {
        return MChineseName;
    }

    public void setMChineseName(String MChineseName) {
        this.MChineseName = MChineseName;
    }

    public String getMOriginName() {
        return MOriginName;
    }

    public void setMOriginName(String MOriginName) {
        this.MOriginName = MOriginName;
    }

    public String getMType() {
        return MType;
    }

    public void setMType(String MType) {
        this.MType = MType;
    }

    public double getMRating() {
        return MRating;
    }

    public void setMRating(double MRating) {
        this.MRating = MRating;
    }

    public int getMRatingCount() {
        return MRatingCount;
    }

    public void setMRatingCount(int MRatingCount) {
        this.MRatingCount = MRatingCount;
    }

    public Date getMReleaseDate() {
        return MReleaseDate;
    }

    public void setMReleaseDate(Date MReleaseDate) {
        this.MReleaseDate = MReleaseDate;
    }

    public int getDirectorId() {
        return DirectorId;
    }

    public void setDirectorId(int directorId) {
        DirectorId = directorId;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String getmLength() {
        return mLength;
    }

    public void setmLength(String mLength) {
        this.mLength = mLength;
    }

    public String getmArea() {
        return mArea;
    }

    public void setmArea(String mArea) {
        this.mArea = mArea;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmCover() {
        return mCover;
    }

    public void setmCover(String mCover) {
        this.mCover = mCover;
    }
}
