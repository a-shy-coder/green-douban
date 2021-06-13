package team.sdguys.dao;

import team.sdguys.entity.Movie;

import java.util.List;

/**
 * 电影收藏表接口
 */
public interface MovieCollectionDao extends BaseDao{

    /**
     * 通过 电影编号找到 收藏这部电影的用户编号列表
     * @param movieId 电影编号
     * @return 用户编号列表
     */
    public List<Integer> getUidListByMovieId(int movieId);

    /**
     * 通过 用户编号 找到用户收藏的电影id列表
     * @param uid 用户编号
     * @return 电影id列表
     */
    public List<Integer> getMovieIdListByUid(int uid);

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
    public int deleteMovieCollectionByUidAndMovieId(int uid, int movieId);
}
