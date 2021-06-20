package team.sdguys.dao;

import team.sdguys.entity.MovieActor;

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

    /**
     * 插入一条新的电影演员信息
     * @param movieActor 新的电影演员信息
     * @return 受影响的行数
     */
    public int insertNewMovieWithActorsInfo(MovieActor movieActor);

    /**
     * 删除参演人员
     * @param movieId
     * @param actorId
     * @return
     */
    int deleteRecordByMovieIdAndActorId(int movieId, int actorId);

    /**
     * 添加电影演员
     * @param movieId
     * @param actorId
     * @return
     */
    int addMovieActor(int movieId, int actorId);
}
