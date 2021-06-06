package team.sdguys.entity;

/**
 * 电影收藏实体类
 */
public class MovieCollection {
    // 电影收藏编号
    private int MCollectionId;
    // 电影编号
    private int MId;
    // 用户编号
    private int UId;

    public MovieCollection(int MCollectionId,int MId, int UId){
        this.MCollectionId = MCollectionId;
        this.MId = MId;
        this.UId = UId;

    }

    public int getMCollectionId() {
        return MCollectionId;
    }

    public void setMCollectionId(int MCollectionId) {
        this.MCollectionId = MCollectionId;
    }

    public int getMId() {
        return MId;
    }

    public void setMId(int MId) {
        this.MId = MId;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }
}
