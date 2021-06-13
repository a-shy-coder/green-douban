package team.sdguys.test.dao;

import team.sdguys.dao.MovieActorDao;
import team.sdguys.dao.impl.MovieActorDaoImpl;

import java.util.List;

public class MovieActorDaoTest {
    public static void main(String[] args) {
        MovieActorDao movieActorDao = new MovieActorDaoImpl();
        List<Integer> list = movieActorDao.getActorIdListByMovieId(1);
     }
}
