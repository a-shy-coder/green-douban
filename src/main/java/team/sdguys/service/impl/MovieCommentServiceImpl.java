package team.sdguys.service.impl;

import team.sdguys.dao.MovieCommentDao;
import team.sdguys.dao.impl.MovieCommentDaoImpl;
import team.sdguys.entity.MovieComment;
import team.sdguys.service.MovieCommentService;

import java.util.List;

/**
 * MovieCommentService 接口的实现类
 */
public class MovieCommentServiceImpl implements MovieCommentService {

    MovieCommentDao movieCommentDao = new MovieCommentDaoImpl();


    @Override
    public List<MovieComment> findMovieCommentListByMovieId(int movieId) {
        return movieCommentDao.getMovieCommentListByMovieId(movieId);
    }


    @Override
    public int submitMovieComment(MovieComment movieComment) {
        return movieCommentDao.insertMovieComment(movieComment);
    }

    @Override
    public int deleteComment(int mcid, int uid) {
        return movieCommentDao.deleteComment(mcid,uid);
    }

    @Override
    public int updateComment(int mcid, int uid, String content) {
        return movieCommentDao.updateComment(mcid,uid,content);
    }
}
