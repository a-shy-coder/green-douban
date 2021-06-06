package team.sdguys.service.impl;

import team.sdguys.dao.MovieRatingDao;
import team.sdguys.dao.impl.MovieRatingDaoImpl;
import team.sdguys.entity.MovieRating;
import team.sdguys.service.MovieRatingService;

public class MovieRatingServiceImpl implements MovieRatingService {

    MovieRatingDao movieRatingDao = new MovieRatingDaoImpl();

    @Override
    public double findMovieRatingByUidAndMovieId(int uid, int movieId) {
        MovieRating movieRating = movieRatingDao.getMovieRatingByUidAndMovieId(uid, movieId);
        if(movieRating == null){
            return 0;
        }else{
            return movieRating.getRating();
        }
    }

    @Override
    public int modifyMovieRating(int uid, int movieId, double movieRating) {
        // 没有记录, 就插入一条记录,有记录, 就更新一条记录
        if(movieRatingDao.getMovieRatingByUidAndMovieId(uid,movieId) == null){
            return movieRatingDao.insertMovieRating(uid,movieId,movieRating);
        }else{
            return movieRatingDao.updateMovieRatingByUidAndMovieId(uid, movieId, movieRating);
        }
    }
}
