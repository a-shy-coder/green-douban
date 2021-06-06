package team.sdguys.entity;

/**
 * 作者实体类
 */
public class Author {
    // 作者编号
    private  int AuthorId;
    //中文名
    private  String AuthorChineseName;
    //原名
    private String AuthorOriginName;
    //导演简介
    private String AuthorInfo;
    //性别
    private String AuthorGender;
    //个人照
    private String AuthorImg;

    public Author(){

    }
    public Author(int AuthorId,String AuthorChineseName, String AuthorOriginName, String AuthorInfo, String AuthorGender, String AuthorImg){
        this.AuthorId = AuthorId;
        this.AuthorChineseName = AuthorChineseName;
        this.AuthorOriginName = AuthorOriginName;
        this.AuthorInfo = AuthorInfo;
        this.AuthorGender = AuthorGender;
        this.AuthorImg = AuthorImg;

    }

    public Author(String AuthorChineseName, String AuthorOriginName, String AuthorInfo, String AuthorGender, String AuthorImg){
        this.AuthorChineseName = AuthorChineseName;
        this.AuthorOriginName = AuthorOriginName;
        this.AuthorInfo = AuthorInfo;
        this.AuthorGender = AuthorGender;
        this.AuthorImg = AuthorImg;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public String getAuthorChineseName() {
        return AuthorChineseName;
    }

    public void setAuthorChineseName(String authorChineseName) {
        AuthorChineseName = authorChineseName;
    }

    public String getAuthorOriginName() {
        return AuthorOriginName;
    }

    public void setAuthorOriginName(String authorOriginName) {
        AuthorOriginName = authorOriginName;
    }

    public String getAuthorInfo() {
        return AuthorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        AuthorInfo = authorInfo;
    }

    public String getAuthorGender() {
        return AuthorGender;
    }

    public void setAuthorGender(String authorGender) {
        AuthorGender = authorGender;
    }

    public String getAuthorImg() {
        return AuthorImg;
    }

    public void setAuthorImg(String authorImg) {
        AuthorImg = authorImg;
    }
}
