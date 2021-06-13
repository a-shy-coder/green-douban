package team.sdguys.dao;

import team.sdguys.entity.Actor;

import java.util.List;

public interface ActorDao extends BaseDao{

    /**
     * 通过演员编号获取演员信息
     * @param actorId 演员id
     * @return 演员
     */
    public Actor getActorByActorId(int actorId);

}
