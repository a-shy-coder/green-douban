package team.sdguys.service.impl;

import team.sdguys.dao.MovieDao;
import team.sdguys.dao.MovieRatingDao;
import team.sdguys.dao.impl.MovieDaoImpl;
import team.sdguys.dao.impl.MovieRatingDaoImpl;
import team.sdguys.entity.Movie;
import team.sdguys.entity.MovieRating;
import team.sdguys.service.MovieService;

import java.util.ArrayList;
import java.util.List;

/**
 * MovieService接口的实现类
 */
public class MovieServiceImpl implements MovieService {
    MovieDao movieDao = new MovieDaoImpl();
    MovieRatingDao movieRatingDao = new MovieRatingDaoImpl();;

    @Override
    public int findMovieIdByMovieChineseName(String movieChineseName) {
        return movieDao.getMovieIdByMovieChineseName(movieChineseName);
    }

    @Override
    public Movie findMovieById(int id) {
        return movieDao.getMovieByMovieId(id);
    }

    @Override
    public List<Movie> findMovieListByMovieIdList(List<Integer> movieIdList) {
        List<Movie> movieList = new ArrayList<Movie>();
        for(int id : movieIdList){
            movieList.add(findMovieById(id));
        }
        return movieList;
    }

    @Override
    public void modifyMovieRatingByMovieId(double rating, int movieId, int uid) {
        Movie movie = movieDao.getMovieByMovieId(movieId);
        double movieRatingSum = (double) (movie.getMRating() * movie.getMRatingCount());
        movieRatingSum += rating;
        MovieRating movieRating = movieRatingDao.getMovieRatingByUidAndMovieId(uid,movieId);
        int movieRatingCount = movie.getMRatingCount() + 1;
        double currentRating = movieRatingSum / movieRatingCount;
        movieDao.updateMovieRatingAndMovieRatingCountByMovieId(movieId,currentRating,movieRatingCount);


    }

    @Override
    public List<Movie> findTheTop5HighestRatedMoviesByDirectorId(int directorId) {
        return movieDao.getTheTop5HighestRatedMoviesByDirectorId(directorId);
    }

    @Override
    public List<Movie> findTheLatest5MoviesByDirectorId(int directorId) {
        return movieDao.getTheLatest5MoviesByDirectorId(directorId);
    }

    @Override
    public List<Movie> findTheTop5HighestRatedMoviesByActorId(int actorId) {
        return movieDao.getTheTop5HighestRatedMoviesByActorId(actorId); //
    }

    @Override
    public List<Movie> findTheLatest5MoviesByActorId(int actorId) {
        return movieDao.getTheLatest5MoviesByActorId(actorId);
    }

    @Override
    public List<Movie> findMovieByPage(int pageNo, int defaultPageSize) {
        return movieDao.getMovieByPage(pageNo, defaultPageSize);
    }

    @Override
    public int getMovieCount() {
        return movieDao.getMovieCount();
    }

    @Override
    public void deleteMovieByMovieId(int mid) {
        movieDao.deleteMovieByMid(mid);
    }

    @Override
    public int addMovie(Movie movie) {
        return movieDao.addMovie(movie);
    }

    @Override
    public int modifyMovieById(Movie movie) {
        return movieDao.modifyMovieById(movie);
    }

    @Override
    public int modifyMovieDirectorById(int directorId, int movieId) {
        return movieDao.modifyMovieDirectorById(directorId, movieId);
    }
}
