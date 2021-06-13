package team.sdguys.service;

import team.sdguys.entity.Actor;

import java.util.List;

/**
 * 演员业务接口
 */
public interface ActorService {
    /**
     * 通过演员编号获取演员
     * @param actorId 演员id
     * @return 演员实体类
     */
    public Actor findActorByActorId(int actorId);

    /**
     * 通过演员id列表获取演员列表
     * @param actorIdList 演员id列表
     * @return 演员列表
     */
    public List<Actor> findActorListByActorIdList(List<Integer> actorIdList);
}
