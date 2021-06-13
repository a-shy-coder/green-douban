package team.sdguys.dao;

import team.sdguys.entity.MovieRating;

/**
 * 电影评分表的接口
 */
public interface MovieRatingDao extends BaseDao{

    /**
     * 查找用户对电影的评分
     * @param uid 用户编号
     * @param movieId 电影编号
     * @return 电影评分实体类
     */
    public MovieRating getMovieRatingByUidAndMovieId(int uid, int movieId);

    /**
     * 插入电影评分记录
     * @param uid 用户编号
     * @param movieId 电影编号
     * @param rating 电影评分
     * @return 受影响的行数
     */
    public int insertMovieRating(int uid, int movieId, double rating);

    /**
     * 更新用户对电影的评分
     * @param uid 用户编号
     * @param movieId 电影编号
     * @param movieRating 电影评分
     * @return 受影响的行数
     */
    public int updateMovieRatingByUidAndMovieId(int uid, int movieId, double movieRating);
}
