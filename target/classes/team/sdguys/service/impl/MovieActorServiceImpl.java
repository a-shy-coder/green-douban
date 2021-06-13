package team.sdguys.service.impl;

import team.sdguys.dao.MovieActorDao;
import team.sdguys.dao.impl.MovieActorDaoImpl;
import team.sdguys.entity.MovieActor;
import team.sdguys.service.MovieActorService;

import java.util.List;

public class MovieActorServiceImpl implements MovieActorService {

    MovieActorDao movieActorDao = new MovieActorDaoImpl();

    @Override
    public List<Integer> findActorIdListByMovieId(int movieId) {
        return movieActorDao.getActorIdListByMovieId(movieId);
    }

    @Override
    public int addNewMovieWithActorInfo(MovieActor movieActor) {
        return movieActorDao.insertNewMovieWithActorsInfo(movieActor);
    }
}
