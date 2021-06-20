package team.sdguys.service.impl;

import team.sdguys.dao.DirectorDao;
import team.sdguys.dao.impl.DirectorDaoImpl;
import team.sdguys.entity.Director;
import team.sdguys.service.DirectorService;

import java.util.List;

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

    @Override
    public List<Director> getDirectorList() {
        return directorDao.getDirectorList();
    }

    @Override
    public int getDirectorCount() {
        return directorDao.getDirectorCount();
    }

    @Override
    public List<Director> findDirectorByPage(int pageNo, int defaultPageSize) {
        return directorDao.getDirectorByPage(pageNo,defaultPageSize);
    }

    @Override
    public int deleteDirectorById(int directorId) {
        return directorDao.deleteDirectorById(directorId);
    }

    @Override
    public int addDirector(Director director) {
        return directorDao.addDirector(director);
    }

    @Override
    public int modifyDirectorById(Director director) {
        return directorDao.modifyDirectorById(director);
    }
}
