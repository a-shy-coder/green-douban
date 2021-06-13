package team.sdguys.service.impl;

import team.sdguys.dao.MovieCommentDao;
import team.sdguys.dao.MovieDao;
import team.sdguys.entity.MovieComment;
import team.sdguys.service.MovieCommentManagerService;

public class MovieCommentManagerServiceImpl implements MovieCommentManagerService {
    MovieCommentDao movieCommentDao;
    MovieDao movieDao;
    @Override
    public int deleteMovieCommentByMidAndUid(int mid, int uid) {
        MovieComment movieComment=new MovieComment(0,mid,null,uid,null,0 );
        return movieCommentDao.deleteComment(movieComment);
    }
}
