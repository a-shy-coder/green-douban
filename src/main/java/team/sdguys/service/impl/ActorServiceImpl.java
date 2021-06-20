package team.sdguys.service.impl;

import team.sdguys.dao.ActorDao;
import team.sdguys.dao.impl.ActorDaoImpl;
import team.sdguys.entity.Actor;
import team.sdguys.service.ActorService;

import java.util.ArrayList;
import java.util.List;

/**
 * 演员业务接口实现类
 */
public class ActorServiceImpl implements ActorService {

    ActorDao actorDao = new ActorDaoImpl();

    @Override
    public Actor findActorByActorId(int actorId) {
        return actorDao.getActorByActorId(actorId);
    }

    @Override
    public List<Actor> findActorListByActorIdList(List<Integer> actorIdList) {
        List<Actor> actorList = new ArrayList<Actor>();
        for(int actorId: actorIdList){
            Actor actor = actorDao.getActorByActorId(actorId);
            actorList.add(actor);
        }
        return actorList;
    }

    @Override
    public List<Actor> getActorList() {
        return actorDao.getActorList();
    }

    @Override
    public int getActorCount() {
        return actorDao.getActorCount();
    }

    @Override
    public List<Actor> findActorByPage(int pageNo, int defaultPageSize) {
        return actorDao.getActorByPage(pageNo,defaultPageSize);
    }

    @Override
    public int deleteActorById(int actorId) {
        return actorDao.deleteActorById(actorId);
    }

    @Override
    public int addActor(Actor actor) {
        return actorDao.addActor(actor);
    }

    @Override
    public int modifyActorById(Actor actor) {
        return actorDao.modifyActorById(actor);
    }
}
