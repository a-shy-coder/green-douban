package team.sdguys.dao.impl;

import team.sdguys.dao.BookReplyDao;
import team.sdguys.entity.BookReply;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class BookReplyDaoImpl extends  BaseDaoImpl implements BookReplyDao {
    @Override
    public BookReply getBookReplyByBRId(int BRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BookReply bookReply = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from BookReply where BRId=?");
            preparedStatement.setInt(1, BRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookReply = new BookReply(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTime(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookReply;    }

    @Override
    public List<Integer> getBRIdListByBCId(int BCId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BRId from BookReply where BCId = ?");
            preparedStatement.setInt(1, BCId);
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
    public int insertReply(BookReply bookReply) {
        return executeUpdate("insert into BookReply (BRFromId,BRToId,BRContent,BRTime,BId,BCId,BRLikeCount) value (?,?,?,?,?,?,0)",bookReply.getBRFromId(),bookReply.getBRToId(),bookReply.getBRContent(),bookReply.getBRTime(),bookReply.getBId(),bookReply.getBCId());
    }


}
