package team.sdguys.test.dao;

import team.sdguys.dao.ActorDao;
import team.sdguys.dao.impl.ActorDaoImpl;
import team.sdguys.entity.Actor;

public class ActorDaoTest {
    public static void main(String[] args) {
        ActorDao actorDao = new ActorDaoImpl();
        Actor actor = actorDao.getActorByActorId(1);

    }
}
