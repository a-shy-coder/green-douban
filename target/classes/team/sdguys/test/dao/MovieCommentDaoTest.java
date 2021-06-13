package team.sdguys.test.dao;

import team.sdguys.dao.MovieCommentDao;
import team.sdguys.dao.impl.MovieCommentDaoImpl;
import team.sdguys.entity.MovieComment;

import java.util.List;

public class MovieCommentDaoTest {
    public static void main(String[] args) {
        MovieCommentDao movieCommentDao = new MovieCommentDaoImpl();
        List<MovieComment> movieCommentList = movieCommentDao.getMovieCommentListByMovieId(1);
    }
}
