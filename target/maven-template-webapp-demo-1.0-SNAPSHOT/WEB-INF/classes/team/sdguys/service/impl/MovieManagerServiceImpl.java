package team.sdguys.service.impl;

import team.sdguys.dao.DirectorDao;
import team.sdguys.dao.MovieDao;
import team.sdguys.entity.Director;
import team.sdguys.entity.Movie;
import team.sdguys.service.MovieManagerService;

public class MovieManagerServiceImpl implements MovieManagerService {
    MovieDao movieDao;
    DirectorDao directorDao;
    @Override
    public int addWholeMovie(Movie movie) {
        Director director=directorDao.getDirectorByDirectorId( movie.getDirectorId() );

        if(director==null){
            return 0;
        }
        else{
            return movieDao.insertMovie(movie);
        }
    }

    @Override
    public int deleteMovieById(int mid) {
        return movieDao.deleteMovieByMid(mid);
    }
}
