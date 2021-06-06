package team.sdguys.entity;

/**
 * 图书评分实体类
 */
public class BookRating {

    // 图书编号
    private int bookId;
    // 评分用户
    private int uId;
    // 评分
    private double rating;

    public BookRating(int bookId, int uId, double rating) {
        this.bookId = bookId;
        this.uId = uId;
        this.rating = rating;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
