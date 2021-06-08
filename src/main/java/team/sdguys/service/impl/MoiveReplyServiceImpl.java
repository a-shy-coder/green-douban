package team.sdguys.service.impl;

import team.sdguys.dao.MovieReplyDao;
import team.sdguys.dao.impl.MovieReplyDaoImpl;
import team.sdguys.service.MoiveReplyService;

/**
 * 电影回复的逻辑业务接口的实现类
 */
public class MoiveReplyServiceImpl implements MoiveReplyService {

    MovieReplyDao movieReplyDao = new MovieReplyDaoImpl();

    @Override
    public void updateLikeCountByMovieReplyId(int movieReplyId, int i) {
        movieReplyDao.updateLikeCountByMovieReplyId(movieReplyId,i);
    }
}
