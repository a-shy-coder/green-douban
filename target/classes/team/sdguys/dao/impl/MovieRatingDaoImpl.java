package team.sdguys.dao.impl;

import team.sdguys.dao.MovieRatingDao;
import team.sdguys.entity.MovieRating;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 电影评分表的实现类
 */
public class MovieRatingDaoImpl extends  BaseDaoImpl implements MovieRatingDao {

    @Override
    public MovieRating getMovieRatingByUidAndMovieId(int uid, int movieId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        MovieRating movieRating = null;

        try {
            connection = DataBaseUtil.getConnection();

            preparedStatement = connection.prepareStatement("select * from movieRating where uid = ? and movieId = ?");
            preparedStatement.setInt(1,uid);
            preparedStatement.setInt(2,movieId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                movieRating = new MovieRating(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieRating;
    }

    @Override
    public int insertMovieRating(int uid, int movieId, double rating) {
        return executeUpdate("insert into movierating (movieId, uid, rating) values (?, ?, ?)",movieId,uid,rating);
    }

    @Override
    public int updateMovieRatingByUidAndMovieId(int uid, int movieId, double movieRating) {
        return executeUpdate("update movierating set rating = ? where uId = ? and movieId = ?",movieRating,uid,movieId);
    }
}
