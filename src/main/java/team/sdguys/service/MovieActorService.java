package team.sdguys.service;

import team.sdguys.entity.MovieActor;

import java.util.List;

/**
 * 电影演员业务接口
 */
public interface MovieActorService {
    /**
     * 通过电影id找道演员列表
     * @param movieId 电影id
     * @return 演员列表
     */
    public List<Integer> findActorIdListByMovieId(int movieId);

    /**
     * 添加新电影演员关系
     * @param movieActor 新电影演员关系
     * @return
     */
    public int addNewMovieWithActorInfo(MovieActor movieActor);
}
