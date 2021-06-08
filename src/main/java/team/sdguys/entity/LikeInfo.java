package team.sdguys.entity;

/**
 * 点赞详情实体类, 防止用户对同一评论点赞
 */
public class LikeInfo {
    // 自增编号
    int id;
    // 用户编号
    int uId;
    // 点赞的电影/书籍的评论/回复编号
    int likeId;
    // 类型: 点赞的是电影/书籍的评论/回复 0(电影评论) 1(电影回复) 2(书籍评论) 3(书籍回复)
    int type;

    public LikeInfo(int id, int uId, int likeId, int type) {
        this.id = id;
        this.uId = uId;
        this.likeId = likeId;
        this.type = type;
    }

    public LikeInfo(int uId, int likeId, int type) {
        this.uId = uId;
        this.likeId = likeId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
