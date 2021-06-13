package team.sdguys.entity;

/**
 * 图书收藏实体类
 */
public class BookCollection {

    // 图书收藏编号
    private int BCollectionId;
    // 图书编号
    private int BId;
    // 用户编号
    private int UId;


    public BookCollection(int BCollectionId, int BId, int UId) {
        this.BCollectionId = BCollectionId;
        this.BId = BId;
        this.UId = UId;
    }

    public BookCollection(int BId, int UId){
        this.UId= UId;
        this.BId = BId;

    }

    public int getBCollectionId() {
        return BCollectionId;
    }

    public void setBCollectionId(int BCollectionId) {
        this.BCollectionId = BCollectionId;
    }

    public int getBId() {
        return BId;
    }

    public void setBId(int BId) {
        this.BId = BId;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }
}
