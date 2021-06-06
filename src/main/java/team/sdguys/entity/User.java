package team.sdguys.entity;

/**
 * 用户实体类
 */
public class User {
    // 用户编号(唯一标识)
    private int uid;
    // 用户登录注册邮箱
    private String uemail;
    // 用户密码
    private String upassword;
    // 用户昵称
    private String uname;

    // 构造器
    public User() {
    }

    public User(int uid, String uemail, String upassword, String uname) {
        this.uid = uid;
        this.uemail = uemail;
        this.upassword = upassword;
        this.uname = uname;
    }

    public User(String uemail, String upassword, String uname) {
        this.uemail = uemail;
        this.upassword = upassword;
        this.uname = uname;
    }

    // getter setter
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
