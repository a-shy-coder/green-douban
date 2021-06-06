package team.sdguys.service.impl;

import team.sdguys.dao.DirectorDao;
import team.sdguys.dao.impl.DirectorDaoImpl;
import team.sdguys.entity.Director;
import team.sdguys.service.DirectorService;

public class DirectorServiceImpl implements DirectorService {

    DirectorDao directorDao = new DirectorDaoImpl();

    @Override
    public Director findDirectorByDirectorId(int directorId) {
        return directorDao.getDirectorByDirectorId(directorId);
    }

    @Override
    public int addNewDirector(Director director) {
        return 0;
    }
}
