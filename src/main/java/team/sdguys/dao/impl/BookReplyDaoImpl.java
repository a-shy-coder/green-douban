package team.sdguys.dao.impl;

import team.sdguys.dao.BookReplyDao;
import team.sdguys.entity.BookReply;
import team.sdguys.entity.BookReply;
import team.sdguys.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int autoIncrementId = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("insert into BookReply (BRFromId,BRToId,BRContent,BRTime,BId,BCId,BRLikeCount) value (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,bookReply.getBRFromId());
            preparedStatement.setInt(2,bookReply.getBRToId());
            preparedStatement.setString(3,bookReply.getBRContent());
            preparedStatement.setObject(4, bookReply.getBRTime());
            preparedStatement.setInt(5,bookReply.getBId());
            preparedStatement.setInt(6,bookReply.getBCId());
            preparedStatement.setInt(7,bookReply.getBRLikeCount());

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
    public List<Integer> getBridlistbyBCId(List<Integer> list) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> bridlist = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BRId from BookReply where BCId=?");
            for(int i = 0;i<list.size();i++){
                preparedStatement.setInt(1, list.get(i));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    bridlist.add(resultSet.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bridlist;    }

    @Override
    public List<BookReply> getBookReplybybrid(List<Integer> bridlist) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookReply> brlist = null;

        BookReply bookReply = null;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from BookReply where BRId=?");
            for(int i = 0;i<bridlist.size();i++){
                preparedStatement.setInt(1, bridlist.get(i));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    bookReply = new BookReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getDate(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                    brlist.add(bookReply);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return brlist;    }

    @Override
    public List<Integer> getBridListbyUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> bridlist = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BRId from BookReply where UId=?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bridlist.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bridlist;
    }

    @Override
    public int updateLikeCountByBookReplyId(int bookReplyId, int i) {
        return executeUpdate("UPDATE bookReply SET BRLikeCount = BRLikeCount + ? WHERE BRId = ?",i,bookReplyId);
    }

    @Override
    public List<BookReply> getBookReplyListByBookCommentId(int bcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookReply> bookReplyList = new ArrayList<BookReply>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM bookreply WHERE BCId = ?");
            preparedStatement.setInt(1,bcId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookReply bookReply = new BookReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                bookReplyList.add(bookReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookReplyList;
    }

    @Override
    public List<BookReply> getBookReplyListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookReply> bookReplyList = new ArrayList<BookReply>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM bookreply WHERE BRFromId = ?");
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookReply bookReply = new BookReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                bookReplyList.add(bookReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookReplyList;
    }

    @Override
    public int deleteBookReplyByBookReplyId(int bookReplyId) {
        return executeUpdate("DELETE FROM bookreply WHERE BRId = ?",bookReplyId);
    }


}
