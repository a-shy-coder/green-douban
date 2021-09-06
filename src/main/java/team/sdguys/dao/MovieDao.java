package team.sdguys.dao;

import team.sdguys.entity.Movie;

import java.sql.SQLException;
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

    /**
     * 插入一条电影信息
     * @param movie 电影
     * @return 受影响的行数
     */
    int insertMovie(Movie movie);



    /**
     * 根据图书编号Mid删除图书
     * @param mid 图书编号
     * @return 受影响的行数
     */
    int deleteMovieByMid(int mid);


    /**
     * 分页查询电影
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Movie> getMovieByPage(int pageNo, int defaultPageSize);

    /**
     * 查询电影总本数
     * @return
     */
    int getMovieCount();

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

    /**
     * @Description: TODO 通过电影名字模糊查找电影
     * @param name 电影的名字
     * @Date 2021年5月30日
     * */
    List<Movie> getMovieByLikeName(String name) throws SQLException;

    /**
     * @description: TODO 首页电影推荐，随机找到6部电影
     * @return 六部电影的详细信息
     * */
    List<Movie> getRecommandMovies() throws SQLException;

    /**
     * @description: TODO 根据电影类型查找到12部电影
     * */
    List<Movie> getMovieByType(String type);

    /**
     * @description: TODO 通过电影年份和种类查找对应的电影
     * */
    List<Movie> getMovieByYearAndType(String type, String year);

    /**
     * @description: TODO 查找某种类电影的数量
     * */
    //int getNumFromType();

    /**
     * @description: TODO 获取某种类电影并分页
     * */
    List<Movie> getMovieByTypeAndApart(String type);
}
