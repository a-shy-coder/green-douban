package team.sdguys.dao;

import team.sdguys.entity.Movie;

import java.util.List;

/**
 * 针对电影表的操作
 */
public interface MovieDao extends BaseDao{
    /**
     * 通过电影中文名找到电影id
     * @param chineseName 电影中文名
     * @return 电影id
     */
    public int getMovieIdByMovieChineseName(String chineseName);

    /**
     * 通过电影id找到电影
     * @param id 电影id
     * @return 电影
     */
    public Movie getMovieByMovieId(int id);

    /**
     * 更新电影评分和评分人数
     * @param movieId 电影编号
     * @param movieRating 电影评分
     * @param movieRatingCount 电影评分人数
     * @return 受影响的行数
     */
    int updateMovieRatingAndMovieRatingCountByMovieId(int movieId, double movieRating,int movieRatingCount);

    /**
     * 找到导演拍摄的最受欢迎的5部电影
     * @param directorId 导演编号
     * @return 最受欢迎的5部电影列表
     */
    List<Movie> getTheTop5HighestRatedMoviesByDirectorId(int directorId);

    /**
     * 找到导演拍摄的最新的5部电影
     * @param directorId 导演编号
     * @return 最新的5部电影列表
     */
    List<Movie> getTheLatest5MoviesByDirectorId(int directorId);

    /**
     * 嵌套子查询!
     * 找到演员拍摄的最受欢迎的5部电影
     * @param actorId 演员编号
     * @return 最受欢迎的5部电影列表
     */
    List<Movie> getTheTop5HighestRatedMoviesByActorId(int actorId);

    /**
     * 嵌套子查询
     * 找到演员拍摄的最新的5部电影
     * @param actorId 演员编号
     * @return 最新的5部电影列表
     */
    List<Movie> getTheLatest5MoviesByActorId(int actorId);
}
