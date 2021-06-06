package team.sdguys.dao.impl;

import team.sdguys.dao.BookCollectionDao;
import team.sdguys.entity.BookCollection;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BookCollectionDao的实现类
 */
public class BookCollectionDaoImpl extends BaseDaoImpl implements BookCollectionDao {

    @Override
    public BookCollection getBookCollectionByBCollectionId(int bCollectionId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BookCollection BookCollection = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from BookCollection where bCollectionId=?");
            preparedStatement.setInt(1, bCollectionId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                BookCollection = new BookCollection(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return BookCollection;

    }

    @Override
    public List<Integer> getBIdListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();

        try{
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from BookCollection where UId = ?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add((resultSet.getInt(1)));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(resultSet,preparedStatement,connection);
        }
        return list;    }

    @Override
    public List<Integer> getUIdListByBid(int bid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();

        try{
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select UId from BookCollection where BId = ?");
            preparedStatement.setInt(1, bid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add((resultSet.getInt(1)));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(resultSet,preparedStatement,connection);
        }
        return list;    }

    @Override
    public int getBookCollectionCountByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int collectnum = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select count(bCollectionId) from BookCollection where UId=?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                collectnum = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return collectnum;
    }

    @Override
    public List<Integer> getTop5Bid() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from BookCollection order by (select Count(bCollectionId) from BookCollection order by BId) desc limit 5");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public int deleteBookCollectionByBidAndUid(int bid, int uid) {
        return executeUpdate("delete from BookCollection where BId = ? and UId = ?",bid,uid);
    }

    @Override
    public int insertBookCollectionByBidAndUid(int bid, int uid) {
        return executeUpdate("insert into BookCollection (BId,UId) value(?,?)",bid,uid);
    }
}
