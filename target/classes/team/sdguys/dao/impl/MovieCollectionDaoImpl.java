package team.sdguys.dao.impl;

import team.sdguys.dao.MovieCollectionDao;
import team.sdguys.entity.Director;
import team.sdguys.entity.Movie;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieCollectionDaoImpl extends BaseDaoImpl implements MovieCollectionDao {
    @Override
    public List<Integer> getUidListByMovieId(int movieId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> uidList = new ArrayList<Integer>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select uid from MovieCollection Where Mid = ?");
            preparedStatement.setInt(1,movieId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                uidList.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return uidList;
    }

    @Override
    public List<Integer> getMovieIdListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> movieIdList = new ArrayList<Integer>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select Mid from MovieCollection Where Uid = ?");
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movieIdList.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return movieIdList;
    }

    @Override
    public int addMovieCollection(int uid, int movieId) {
        return executeUpdate("insert into moviecollection (MId, UId) VALUES (?, ?)",movieId,uid);
    }

    @Override
    public int deleteMovieCollectionByUidAndMovieId(int uid, int movieId) {
        return executeUpdate("delete from moviecollection where uid = ? and mid = ?",uid,movieId);
    }
}
