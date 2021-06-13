package team.sdguys.entity;

/**
 * 导演实体类
 */
public class Director {
    // 导演编号
    private int directorId;
    // 导演中文名
    private String directorChineseName;
    // 导演原名
    private String directorOriginName;
    // 导演简介
    private String directorInfo;
    // 导演性别
    private String directorGender;
    // 导演个人照
    private String directorImg;

    public Director(int directorId, String directorChineseName, String directorOriginName, String directorInfo, String directorGender, String directorImg) {
        this.directorId = directorId;
        this.directorChineseName = directorChineseName;
        this.directorOriginName = directorOriginName;
        this.directorInfo = directorInfo;
        this.directorGender = directorGender;
        this.directorImg = directorImg;
    }

    public Director(String directorChineseName, String directorOriginName, String directorInfo, String directorGender, String directorImg) {
        this.directorChineseName = directorChineseName;
        this.directorOriginName = directorOriginName;
        this.directorInfo = directorInfo;
        this.directorGender = directorGender;
        this.directorImg = directorImg;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDirectorChineseName() {
        return directorChineseName;
    }

    public void setDirectorChineseName(String directorChineseName) {
        this.directorChineseName = directorChineseName;
    }

    public String getDirectorOriginName() {
        return directorOriginName;
    }

    public void setDirectorOriginName(String directorOriginName) {
        this.directorOriginName = directorOriginName;
    }

    public String getDirectorInfo() {
        return directorInfo;
    }

    public void setDirectorInfo(String directorInfo) {
        this.directorInfo = directorInfo;
    }

    public String getDirectorGender() {
        return directorGender;
    }

    public void setDirectorGender(String directorGender) {
        this.directorGender = directorGender;
    }

    public String getDirectorImg() {
        return directorImg;
    }

    public void setDirectorImg(String directorImg) {
        this.directorImg = directorImg;
    }
}
