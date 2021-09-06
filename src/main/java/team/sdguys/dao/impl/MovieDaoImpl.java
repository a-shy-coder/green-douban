package team.sdguys.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.sdguys.dao.MovieDao;
import team.sdguys.entity.BookCollection;
import team.sdguys.entity.Movie;
import team.sdguys.util.DataBaseUtil;
import team.sdguys.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Override
    public int insertMovie(Movie movie) {
        return executeUpdate("insert into Movie (MovieId,MChineseName,MOriginName,MType,MRating,MRatingCount,MReleaseDate,DirectorId,mLanguage,mLength,mArea,mContent,mCover) value (?,?,?,?,?,?,?,?,?,?,?,?,?)", movie.getMovieId(), movie.getMChineseName(), movie.getMOriginName(), movie.getMType(), movie.getMRating() ,movie.getMRatingCount() ,movie.getMReleaseDate() ,movie.getDirectorId() ,movie.getmLanguage() ,movie.getmLength() ,movie.getmArea() ,movie.getmContent() ,movie.getmCover() );

    }


    @Override
    public int deleteMovieByMid(int mid) {
        return executeUpdate("delete from Movie where MovieId = ?",mid);

    }

    @Override
    public List<Movie> getMovieByPage(int pageNo, int pageSize) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Movie limit ?, ?");
            ps.setInt(1, (pageNo - 1) * pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int Mid = rs.getInt(1);
                String MChineseName = rs.getString(2);
                String MOriginName = rs.getString(3);
                String MType = rs.getString(4);
                Double MRating = rs.getDouble(5);
                Integer MRatingCount = rs.getInt(6);
                Date MReleaseDate = rs.getDate(7);
                Integer DirectorId = rs.getInt(8);
                String mLanguage = rs.getString(9);
                String mLength = rs.getString(10);
                String mArea = rs.getString(11);
                String mContent = rs.getString(12);
                String mCover = rs.getString(13);



                Movie movie= new Movie(Mid, MChineseName, MOriginName, MType, MRating, MRatingCount, MReleaseDate, DirectorId, mLanguage, mLength, mArea, mContent, mCover);
                list.add(movie);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int getMovieCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from Movie");
            rs = ps.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return count;
    }

    @Override
    public int addMovie(Movie movie) {
        return executeUpdate("INSERT INTO movie (MChineseName, MOriginName, MType, MRating, MRatingCount, MReleaseDate, DirectorId, MLanguage, MLength, MArea, MContent, MCover) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",movie.getMChineseName(),movie.getMOriginName(),movie.getMType(),movie.getMRating(),movie.getMRatingCount(),movie.getMReleaseDate(),movie.getDirectorId(),movie.getmLanguage(),movie.getmLength(),movie.getmArea(),movie.getmContent(),movie.getmCover());
    }

    @Override
    public int modifyMovieDirectorById(int directorId, int movieId) {
        return executeUpdate("UPDATE movie SET DirectorId = ? WHERE MovieId = ?",directorId,movieId);
    }

    @Override
    public int modifyMovieById(Movie movie) {
        return executeUpdate("UPDATE movie \n" +
                "        SET MChineseName = ?,MOriginName  = ?,MType = ?, MRating = ?, MRatingCount = ?, MReleaseDate = ?, DirectorId = ?, MLanguage = ?, MLength = ?, MArea = ?, MContent = ?, MCover = ?\n" +
                "        WHERE MovieId = ?", movie.getMChineseName(),movie.getMOriginName(),movie.getMType(),movie.getMRating(),movie.getMRatingCount(),movie.getMReleaseDate(),movie.getDirectorId(),movie.getmLanguage(),movie.getmLength(),movie.getmArea(),movie.getmContent(),movie.getmCover(),movie.getMovieId());



    }

    @Override
    public List<Movie> getMovieByLikeName(String name) throws SQLException {
        String sql = "select * from movie where MChineseName like ? or MOriginName like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Movie>(Movie.class), "%"+name+"%", "%"+name+"%");
    }

    @Override
    public List<Movie> getRecommandMovies() throws SQLException{
        Random random = new Random(20);
        int[] temp = {1,1,2,3,4,5,6};
        for(int i=0; i<6; i++){
            temp[i] = random.nextInt(20)+i;
        }
        String sql = "select * from movie where MovieId in (?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Movie>(Movie.class),temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
    }

    @Override
    public List<Movie> getMovieByType(String type) {
        String sql = "select * from Movie where Mtype like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql, new BeanListHandler<Movie>(Movie.class), "%"+type+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMovieByYearAndType(String type, String year) {
        return null;
    }

    @Override
    public List<Movie> getMovieByTypeAndApart(String type) {
        return null;
    }

    /**
     * TODO:根据电影时间倒序查询
     * */
    public List<Movie> getNewMovieByMReleaseDateDesc(){
        String sql = "select * from Movie order by MReleaseDate desc";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql,new BeanListHandler<Movie>(Movie.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
