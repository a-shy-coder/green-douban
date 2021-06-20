package team.sdguys.service;

import team.sdguys.entity.Movie;

import java.util.List;

/**
 * 电影业务的相关逻辑
 */
public interface MovieService {
    /**
     * 通过电影中文名获取电影id
     * @param movieChineseName 电影中文名
     * @return 电影id
     */
    public int findMovieIdByMovieChineseName(String movieChineseName);

    /**
     * 通过电影id找到电影
     * @param id 电影id
     * @return 电影实体类
     */
    public Movie findMovieById(int id);

    /**
     * 通过电影id列表找到电影列表
     * @param movieIdList 电影id列表
     * @return 电影列表
     */
    public List<Movie> findMovieListByMovieIdList(List<Integer> movieIdList);

    /**
     * 根据用户评分修改电影的总评分
     * @param rating 用户评分
     * @param movieId 电影编号
     * @param uid 用户编号
     */
    public void modifyMovieRatingByMovieId(double rating, int movieId, int uid);

    /**
     * 找到导演拍摄的最受欢迎的5部电影
     * @param directorId 导演编号
     * @return 最受欢迎的5部电影列表
     */
    public List<Movie> findTheTop5HighestRatedMoviesByDirectorId(int directorId);

    /**
     * 找到导演拍摄的最新的5部电影
     * @param directorId 导演编号
     * @return 最新的5部电影列表
     */
    public List<Movie> findTheLatest5MoviesByDirectorId(int directorId);

    /**
     * 找到演员拍摄的最受欢迎的5部电影
     * @param actorId 导演编号
     * @return 最受欢迎的5部电影列表
     */
    public List<Movie> findTheTop5HighestRatedMoviesByActorId(int actorId);

    /**
     * 找到演员拍摄的最新的5部电影
     * @param actorId 演员编号
     * @return 最新的5部电影列表
     */
    public List<Movie> findTheLatest5MoviesByActorId(int actorId);

    /**
     * 分页查询电影
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Movie> findMovieByPage(int pageNo, int defaultPageSize);

    /**
     * 检索电影总本书
     * @return
     */
    int getMovieCount();

    /**
     * 删除电影
     * @param mid
     */
    void deleteMovieByMovieId(int mid);

    /**
     * 发布电影
     * @param movie
     * @return
     */
    int addMovie(Movie movie);

    /**
     * 修改电影信息
     * @param movie
     * @return
     */
    int modifyMovieById(Movie movie);

    /**
     * 修改电影导演
     * @param directorId
     * @param movieId
     * @return
     */
    int modifyMovieDirectorById(int directorId, int movieId);
}
