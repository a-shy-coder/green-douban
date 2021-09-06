package team.sdguys.service.impl;

import team.sdguys.dao.impl.MovieDaoImpl;
import team.sdguys.entity.Movie;

import java.util.List;

public class MoviePageService {
    MovieDaoImpl movieDao = new MovieDaoImpl();

    /**
     * TODO:最新电影
     * */
    public List<Movie> getNewMovieByMReleaseDateDesc(){
        return movieDao.getNewMovieByMReleaseDateDesc();
    }
    /**
     * TODO:根据电影类型查询电影
     * */
    public List<Movie> getMovieByType(String type) {
        return movieDao.getMovieByType(type);
    }
}
