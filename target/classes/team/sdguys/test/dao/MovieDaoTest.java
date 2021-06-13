package team.sdguys.test.dao;

import team.sdguys.dao.MovieDao;
import team.sdguys.dao.impl.MovieDaoImpl;
import team.sdguys.entity.Movie;

public class MovieDaoTest {
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDaoImpl();
        System.out.println(movieDao.getMovieIdByMovieChineseName("小人物"));
        Movie movie = movieDao.getMovieByMovieId(1);
        System.out.println(movieDao.getMovieByMovieId(1));
    }
}
