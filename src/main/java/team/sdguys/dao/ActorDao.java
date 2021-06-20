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

    /**
     * 检索出所有的演员列表
     * @return
     */
    List<Actor> getActorList();

    /**
     * 检索演员数量
     * @return
     */
    int getActorCount();

    /**
     * 分页查询演员
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Actor> getActorByPage(int pageNo, int defaultPageSize);

    /**
     * 删除演员信息
     * @param actorId
     * @return
     */
    int deleteActorById(int actorId);

    /**
     * 添加演员信息
     * @param actor
     * @return
     */
    int addActor(Actor actor);

    /**
     * 修改演员
     * @param actor
     * @return
     */
    int modifyActorById(Actor actor);
}
