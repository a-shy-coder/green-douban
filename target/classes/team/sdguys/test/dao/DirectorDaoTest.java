package team.sdguys.test.dao;

import team.sdguys.dao.DirectorDao;
import team.sdguys.dao.impl.DirectorDaoImpl;
import team.sdguys.entity.Director;

public class DirectorDaoTest {
    public static void main(String[] args) {
        DirectorDao directorDao = new DirectorDaoImpl();
        Director director = directorDao.getDirectorByDirectorId(1);

    }
}
