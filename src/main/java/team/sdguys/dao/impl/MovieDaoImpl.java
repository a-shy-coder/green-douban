package team.sdguys.dao.impl;

import team.sdguys.dao.MovieDao;
import team.sdguys.entity.BookCollection;
import team.sdguys.entity.Movie;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * MovieDao接口的实现类
 */
public class MovieDaoImpl extends BaseDaoImpl implements MovieDao {
    @Override
    public int getMovieIdByMovieChineseName(String chineseName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int movieId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select MovieId from Movie Where MChineseName = ?");
            preparedStatement.setString(1,chineseName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                movieId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieId;
    }

    @Override
    public Movie getMovieByMovieId(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Movie Where MovieId = ?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                movie = new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5),resultSet.getInt(6),resultSet.getTimestamp(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movie;
    }

    @Override
    public int updateMovieRatingAndMovieRatingCountByMovieId(int movieId, double movieRating,int movieRatingCount) {
        return executeUpdate("update movie set MRating = ?, MRatingCount = ? where MovieId = ?",movieRating,movieRatingCount,movieId);
    }

    @Override
    public List<Movie> getTheTop5HighestRatedMoviesByDirectorId(int directorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from movie where DirectorId = ? order by MRating DESC limit 5");
            preparedStatement.setInt(1,directorId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                movieList.add(new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5),resultSet.getInt(6),resultSet.getTimestamp(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieList;
    }

    @Override
    public List<Movie> getTheLatest5MoviesByDirectorId(int directorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from movie where DirectorId = ? order by MReleaseDate DESC limit 5");
            preparedStatement.setInt(1,directorId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                movieList.add(new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5),resultSet.getInt(6),resultSet.getTimestamp(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieList;
    }

    @Override
    public List<Movie> getTheTop5HighestRatedMoviesByActorId(int actorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * FROM movie where MovieId in ( select movieId FROM movieactor where ActorId = ? ) order by MRating DESC limit 5");
            preparedStatement.setInt(1,actorId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                movieList.add(new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5),resultSet.getInt(6),resultSet.getTimestamp(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieList;
    }

    @Override
    public List<Movie> getTheLatest5MoviesByActorId(int actorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * FROM movie where MovieId in ( select movieId FROM movieactor where ActorId = ? ) order by MReleaseDate DESC limit 5");
            preparedStatement.setInt(1,actorId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                movieList.add(new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5),resultSet.getInt(6),resultSet.getTimestamp(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieList;
    }
}
