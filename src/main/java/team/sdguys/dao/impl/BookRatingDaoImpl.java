package team.sdguys.dao.impl;

import team.sdguys.dao.BookRatingDao;
import team.sdguys.entity.BookRating;
import team.sdguys.entity.MovieRating;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 图书评分表接口的实现类
 */
public class BookRatingDaoImpl extends BaseDaoImpl implements BookRatingDao {

    @Override
    public BookRating getBookRatingByUidAndBookId(int uid, int bookId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BookRating bookRating = null;

        try {
            connection = DataBaseUtil.getConnection();

            preparedStatement = connection.prepareStatement("select * from bookRating where uid = ? and bookId = ?");
            preparedStatement.setInt(1,uid);
            preparedStatement.setInt(2,bookId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookRating = new BookRating(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookRating;
    }

    @Override
    public int insertBookRating(int uid, int bookId, double rating) {
        return executeUpdate("insert into bookrating (bookId, uid, rating) values (?, ?, ?)",bookId,uid,rating);

    }

    @Override
    public int updateBookRatingByUidAndBookId(int uid, int bookId, double bookRating) {
        return executeUpdate("update movierating set rating = ? where uId = ? and bookId = ?",bookRating,uid,bookId);
    }
}
