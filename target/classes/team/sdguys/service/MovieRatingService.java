package team.sdguys.service;

/**
 * 电影评分业务接口
 */
public interface MovieRatingService {

    /**
     * 找到指定用户对指定电影的评分
     * @param uid 用户编号
     * @param movieId 电影编号
     * @return 电影评分
     */
    public double findMovieRatingByUidAndMovieId(int uid, int movieId);

    /**
     * 修改指定用户对电影的评分, 如果还未评分, 则插入一条记录
     * @param uid 用户编号
     * @param movieId 电影编号
     * @param movieRating 电影评分
     * @return 受影响的行数
     */
    public int modifyMovieRating(int uid, int movieId, double movieRating);
}
