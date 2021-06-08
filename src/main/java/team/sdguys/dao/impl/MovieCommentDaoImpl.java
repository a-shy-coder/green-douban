package team.sdguys.dao.impl;

import team.sdguys.dao.MovieCommentDao;
import team.sdguys.entity.MovieComment;
import team.sdguys.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影评论表Dao接口的实现
 */
public class MovieCommentDaoImpl extends BaseDaoImpl implements MovieCommentDao {

    @Override
    public List<MovieComment> getMovieCommentListByMovieId(int movieId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MovieComment> movieCommentList = new ArrayList<MovieComment>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from movieComment Where mId = ?");
            preparedStatement.setInt(1,movieId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MovieComment movieComment = new MovieComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
                movieCommentList.add(movieComment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieCommentList;
    }

    @Override
    public int insertMovieComment(MovieComment movieComment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int autoIncrementId = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO movieComment (MId, MCcontent, UId, MCTime, MCLikeCount) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,movieComment.getMId());
            preparedStatement.setString(2,movieComment.getMCcontent());
            preparedStatement.setInt(3,movieComment.getUId());
            preparedStatement.setObject(4, movieComment.getMCTime());
            preparedStatement.setInt(5,movieComment.getMCLikeCount());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                autoIncrementId = resultSet.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(null, preparedStatement, connection);
        }
        return autoIncrementId;
    }

    @Override
    public int deleteComment(int mcid, int uid) {
        return executeUpdate("delete from MovieComment where MCId = ? and UId = ?",mcid,uid);
    }

    @Override
    public int updateComment(int mcid, int uid, String content) {
        return executeUpdate("update MovieComment set MCcontent = ? where MCId = ? and UId = ?",content,mcid,uid);
    }

    @Override
    public int deleteComment(MovieComment movieComment) {
        return executeUpdate("delete from MovieComment where Mid = ? and Uid = ?",movieComment.getMId(),movieComment.getUId());
    }

    @Override
    public MovieComment getMovieCommentByMovieCommentId(int mcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        MovieComment movieComment = null;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from movieComment Where mcId = ?");
            preparedStatement.setInt(1,mcId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movieComment = new MovieComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieComment;
    }

    @Override
    public int updateLikeCountByMovieCommentId(int movieCommentId, int i) {
        return executeUpdate("UPDATE movieComment SET MCLikeCount = MCLikeCount + ? WHERE MCId = ?",i,movieCommentId);
    }
}
