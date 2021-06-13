package team.sdguys.dao.impl;

import team.sdguys.dao.BookCommentDao;
import team.sdguys.entity.BookComment;
import team.sdguys.entity.BookComment;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * BookComment接口的实现类
 */
public class BookCommentDaoImpl extends  BaseDaoImpl implements BookCommentDao {
    @Override
    public BookComment getBookCommentByBCId(int bcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BookComment BookComment = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from BookComment where BCId=?");
            preparedStatement.setInt(1, bcId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                BookComment = new BookComment(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return BookComment;

    }


    @Override
    public int insertComment(BookComment BookComment) {
        return executeUpdate("insert into BookComment (BId,BCcontnet,UId,BCTime,BCLikeCount) value (?,?,?,?,0)",BookComment.getBId(),BookComment.getBcContent(),BookComment.getUId(),BookComment.getBcTime());
    }

    @Override
    public int deleteComment(int bcid,int uid) {
        return executeUpdate("delete from BookComment where BCId = ? and UId = ?",bcid,uid);
    }

    @Override
    public int deleteComment(BookComment bookComment) {
        return 0;
    }

    @Override
    public int updateComment(int bcid,int uid,String content) {
        return executeUpdate("update BookComment set BCcontent = ? where BCId = ? and UId = ?",content,bcid,uid);
    }

    @Override
    public List<Integer> getTop5BookCommentsList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BCId from BookComment order by BCLikeCount desc limit 5");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;

    }

    @Override
    public int getBLikeCountByBCId(int BCId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from BookComment where BCId=?");
            ps.setString(1, String.valueOf(BCId));
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
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
    public int updateBLikeCountByBCId(int BCId, int BLikeCount) {
        return executeUpdate("update BookComment set BLikeCount=? where BCId=?",BLikeCount,BCId);
    }

    @Override
    public List<BookComment> getBookCommentListByBookId(int bookId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookComment> bookCommentList = new ArrayList<BookComment>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from bookComment Where bId = ?");
            preparedStatement.setInt(1,bookId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookComment bookComment = new BookComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
                bookCommentList.add(bookComment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookCommentList;
    }

    @Override
    public int insertBookComment(BookComment bookComment) {
        return executeUpdate("INSERT INTO bookcomment (BId, BCcontent, UId, BCTime, BCLikeCount) VALUES (?,?,?,?,?)",bookComment.getBId(),bookComment.getBcContent(),bookComment.getUId(),bookComment.getBcTime(),bookComment.getBcLikeCount());
    }

    @Override
    public int updateLikeCountByBookCommentId(int bookCommentId, int i) {
        return executeUpdate("UPDATE bookComment SET BCLikeCount = BCLikeCount + ? WHERE BCId = ?",i,bookCommentId);
    }

    @Override
    public BookComment findBookCommentByBookCommentId(int bcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BookComment bookComment = null;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from bookComment Where bcId = ?");
            preparedStatement.setInt(1,bcId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookComment = new BookComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookComment;
    }

}
