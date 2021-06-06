package team.sdguys.entity;

/**
 * 电影评分实体类
 */
public class MovieRating {

    // 电影编号
    private int movieId;
    // 评分用户
    private int uId;
    // 评分
    private double rating;

    public MovieRating(int movieId, int uId, double rating) {
        this.movieId = movieId;
        this.uId = uId;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
