package team.sdguys.entity;

import java.util.Date;

/**
 * 学生实体类： 存储学生所有信息
 *
 */
public class UserInfo {

    //用户编号
    private int Uid;
    //用户头像
    private String Uicon;
    //用户性别
    private String Ugender;
    //用户所在地
    private String Uaddress;
    //用户生日
    private Date Ubirthday;
    //用户星座
    private String Usign;


    // 构造器
    public UserInfo() {
    }

    public UserInfo(int uid) {
        Uid = uid;
    }

    public UserInfo(int uid, String uicon, String ugender, String uaddress, Date ubirthday, String usign) {
        Uid = uid;
        Uicon = uicon;
        Ugender = ugender;
        Uaddress = uaddress;
        Ubirthday = ubirthday;
        Usign = usign;
    }


    // getter setter
    public int getUid() {
        return Uid;
    }

    public String getUicon() {
        return Uicon;
    }

    public String getUgender() {
        return Ugender;
    }

    public String getUaddress() {
        return Uaddress;
    }

    public Date getUbirthday() {
        return Ubirthday;
    }

    public String getUsign() {
        return Usign;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public void setUicon(String uicon) {
        Uicon = uicon;
    }

    public void setUgender(String ugender) {
        Ugender = ugender;
    }

    public void setUaddress(String uaddress) {
        Uaddress = uaddress;
    }

    public void setUbirthday(Date ubirthday) {
        Ubirthday = ubirthday;
    }

    public void setUsign(String usign) {
        Usign = usign;
    }
}
