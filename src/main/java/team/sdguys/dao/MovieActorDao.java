package team.sdguys.dao;

import java.util.List;

/**
 * 电影演员表的接口
 */
public interface MovieActorDao extends BaseDao{

    /**
     * 通过电影id找到演员列表id
     * @param movieId 电影id
     * @return 演员列表id
     */
    public List<Integer> getActorIdListByMovieId(int movieId);
}
