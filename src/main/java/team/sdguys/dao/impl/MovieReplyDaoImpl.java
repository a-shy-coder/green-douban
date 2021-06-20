package team.sdguys.dao.impl;

import team.sdguys.dao.MovieReplyDao;
import team.sdguys.entity.MovieReply;
import team.sdguys.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影评论Dao的实现层
 */
public class MovieReplyDaoImpl extends BaseDaoImpl implements MovieReplyDao {
    @Override
    public List<MovieReply> getMovieReplyListByMovieCommentId(int mcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MovieReply> movieReplyList = new ArrayList<MovieReply>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM moviereply WHERE MCId = ?");
            preparedStatement.setInt(1,mcId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MovieReply movieReply = new MovieReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                movieReplyList.add(movieReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieReplyList;
    }

    @Override
    public int insertMovieReply(MovieReply movieReply) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int autoIncrementId = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO sdguys.moviereply (MRFromId, MRToId, MRContent, MRTime, MId, MCId, MRLikeCount) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,movieReply.getMRFromId());
            preparedStatement.setInt(2,movieReply.getMRToId());
            preparedStatement.setString(3,movieReply.getMRContent());
            preparedStatement.setObject(4, movieReply.getMRTime());
            preparedStatement.setInt(5,movieReply.getMId());
            preparedStatement.setInt(6,movieReply.getMCId());
            preparedStatement.setInt(7,movieReply.getMRLikeCount());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                autoIncrementId = resultSet.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return autoIncrementId;
    }

    @Override
    public int updateLikeCountByMovieReplyId(int movieReplyId, int i) {
        return executeUpdate("UPDATE movieReply SET MRLikeCount = MRLikeCount + ? WHERE MRId = ?",i,movieReplyId);
    }

    @Override
    public List<MovieReply> getMovieReplyListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MovieReply> movieReplyList = new ArrayList<MovieReply>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM moviereply WHERE MRFromId = ?");
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MovieReply movieReply = new MovieReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                movieReplyList.add(movieReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieReplyList;
    }

    @Override
    public int deleteMovieReplyByMovieReplyId(int movieReplyId) {
        return executeUpdate("DELETE FROM moviereply WHERE MRId = ?",movieReplyId);
    }
}
