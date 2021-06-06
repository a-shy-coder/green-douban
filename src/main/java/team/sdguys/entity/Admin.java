package team.sdguys.entity;

/**
 * 管理员实体类
 */
public class Admin {

    // 管理员编号(自动增长)
    private int aid;
    // 管理员用户名
    private String aUsername;
    // 管理员密码
    private String aPassword;


    // 构造器
    public Admin(){}

    public Admin(int aid, String aUsername, String aPassword) {
        this.aid = aid;
        this.aPassword = aPassword;
        this.aUsername = aUsername;
    }


    public Admin(String aUsername, String aPassword) {
        this.aUsername = aUsername;
        this.aPassword = aPassword;
    }

    // getter setter
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAPassword() {
        return aPassword;
    }

    public void setAPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getAUsername() {
        return aUsername;
    }

    public void setAUsername(String aUsername) {
        this.aUsername = aUsername;
    }
}
