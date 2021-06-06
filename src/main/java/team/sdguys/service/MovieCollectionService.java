package team.sdguys.service;

import team.sdguys.entity.Movie;
import team.sdguys.entity.MovieCollection;

import java.util.List;

/**
 * 电影收藏业务接口
 */
public interface MovieCollectionService {

    /**
     * 通过 电影编号找到 收藏这部电影的用户编号列表
     * @param movieId 电影编号
     * @return 用户编号列表
     */
    public List<Integer> findUidListByMovieId(int movieId);

    /**
     * 通过 用户编号 找到用户收藏的电影列表
     * @param uid 用户编号
     * @return 电影id列表
     */
    public List<Integer> findMovieIdListByUid(int uid);

    /**
     * 找到收藏此电影的其他用户的电影收藏列表
     * @param uid 用户编号
     * @param movieId 电影编号
     * @return 其他用户的电影id列表
     */
    public List<Integer> findOtherMovieIdListByUid(int uid, int movieId);


    /**
     * 根据 uid 和 movieId 判断当前用户是否收藏了该电影
     * @param uid 用户编号
     * @param movieId 电影标号
     * @return true 收藏了  false 未收藏
     */
    public Boolean checkRecordByUidAndMovieId(int uid, int movieId);

    /**
     * 添加电影收藏
     * @param uid 用户编号
     * @param movieId 电影编号
     * @return 受影响的行数
     */
    public int addMovieCollection(int uid, int movieId);

    /**
     * 删除电影收藏
     * @param uid 用户编号
     * @param movieId 电影编号
     * @return 受影响的行数
     */
    public int deleteMovieCollection(int uid, int movieId);
}
