package team.sdguys.service.impl;

import team.sdguys.dao.MovieReplyDao;
import team.sdguys.dao.impl.MovieReplyDaoImpl;
import team.sdguys.entity.MovieReply;
import team.sdguys.service.MovieReplyService;

import java.util.List;

/**
 * 电影回复业务接口的实现类
 */
public class MovieReplyServiceImpl implements MovieReplyService {

    MovieReplyDao movieReplyDao = new MovieReplyDaoImpl();

    @Override
    public List<MovieReply> getMovieReplyListByMovieCommentId(int mcId) {
        return movieReplyDao.getMovieReplyListByMovieCommentId(mcId);
    }

    @Override
    public int submitMovieReply(MovieReply movieReply) {
        return movieReplyDao.insertMovieReply(movieReply);
    }

    @Override
    public List<MovieReply> findMovieReplyListByUid(int uid) {
        return movieReplyDao.getMovieReplyListByUid(uid);
    }
}
