package team.sdguys.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.sdguys.dao.BaseDao;
import team.sdguys.dao.BookDao;
import team.sdguys.entity.Book;
import team.sdguys.entity.Book;
import team.sdguys.util.DataBaseUtil;
import team.sdguys.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * BookDao接口的实现类
 */
public class BookDaoImpl extends BaseDaoImpl implements BookDao {
    @Override
    public int insertBook(Book book) {
        return executeUpdate("insert into Book (BId,BChineseName,BOriginName,BType,BRating,BRatingCount,BReleaseDate,BPublisher,AuthorId,BPageCount,BBinding,BContent,BLanguage,BCover) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", book.getBId(), book.getBChineseName(), book.getBOriginName(), book.getBType(), book.getBRating(), book.getBRatingCount(), book.getBReleaseDate(), book.getBPublisher(), book.getAuthorId(), book.getbPageCount(),book.getbBinding(),book.getbContent(), book.getbLanguage(),book.getbCover());
    }

    @Override
    public Book getBookByBId(int BId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Book where BId=?");
            preparedStatement.setInt(1, BId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return book;
    }

    @Override
    public List<Integer> getBIdListByBType(String BType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from Book where BType = ?");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add((resultSet.getInt(1)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public List<Integer> getBIdListByBPublisher(String BPublisher) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from Book where BPulisher = ?");
            preparedStatement.setString(1, BPublisher);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add((resultSet.getInt(1)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public List<Integer> getBIdListByAuthorId(int AuthorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from Book where AuthorId = ?");
            preparedStatement.setInt(1, AuthorId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add((resultSet.getInt(1)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public int getBIdByBChineseName(String BChineseName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int BId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from Book where BChineseName=?");
            preparedStatement.setString(1, BChineseName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                BId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return BId;
    }

    @Override
    public int getBIdByBOriginName(String BOriginName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int BId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select BId from Book where BOriginName=?");
            preparedStatement.setString(1, BOriginName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                BId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return BId;
    }

    @Override
    public List<Book> getBookListByKeyword(String KeyWord) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        List<Book> list= null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Book where BChineseName like %?% or BOriginName like %?% ");
            preparedStatement.setString(1,KeyWord);
            preparedStatement.setString(2,KeyWord);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));
                list.add(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public int deleteBookByBid(int Bid) {
        return executeUpdate("delete from Book where BId = ?",Bid);
    }

    @Override
    public int updateBook(Book book) {
        return executeUpdate("update Book set (BChinese,BOriginName,BType,BReleaseDate,BPublisher,AuthorId) value (?,?,?,?,?,?)", book.getBChineseName(),book.getBOriginName(),book.getBType(),book.getBReleaseDate(),book.getBPublisher(),book.getAuthorId());
    }

    @Override
    public List<Book> getAllBooksOrderByRatingDesc() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        List<Book> list= null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Book order by BRating desc ");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));
                list.add(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public List<Book> getAllBooksOrderByRatingEsc() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        List<Book> list= null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Book order by BRating asc ");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));
                list.add(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public List<Book> getAllBooksOrderByReleaseDateDesc() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        List<Book> list= null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Book order by BReleaseDate desc ");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));
                list.add(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public int updateBookRatingAndBookRatingCountByBookId(int bookId, double bookRating, int bookRatingCount) {
        return executeUpdate("update book set BRating = ?, BRatingCount = ? where BId = ?",bookRating,bookRatingCount,bookId);

    }

    @Override
    public List<Book> getTheTop5HighestRatedBooksByAuthorId(int authorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> bookList = new ArrayList<Book>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * FROM book where AuthorId = ? Order By BRating desc limit 5;");
            preparedStatement.setInt(1,authorId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                bookList.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookList;
    }

    @Override
    public List<Book> getTheLatest5BooksByAuthorId(int authorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> bookList = new ArrayList<Book>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * FROM book where AuthorId = ? Order By BReleaseDate desc limit 5;");
            preparedStatement.setInt(1,authorId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                bookList.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return bookList;
    }

    @Override
    public List<Book> getBookByPage(int pageNo, int pageSize) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Book limit ?, ?");
            ps.setInt(1, (pageNo-1)*pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int Bid = rs.getInt(1);
                String BChineseName = rs.getString(2);
                String BOriginName = rs.getString(3);
                String BType = rs.getString(4);
                Float BRating = rs.getFloat(5);
                Integer BRatingCount = rs.getInt(6);
                Date BReleaseDate = rs.getDate(7);
                String BPublisher = rs.getString(8);
                Integer AuthorId = rs.getInt(9);
                Integer bPageCount = rs.getInt(10);
                String bBinding = rs.getString(11);
                String bContent = rs.getString(12);
                String bLanguage = rs.getString(13);
                String bCover = rs.getString(14);

                Book book = new Book(Bid , BChineseName, BOriginName, BType, BRating ,BRatingCount , BReleaseDate , BPublisher,AuthorId , bPageCount , bBinding,bContent , bLanguage, bCover);
                list.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }


    @Override
    public int getBookCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from Book");
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
    public int addBook(Book book) {
        return executeUpdate("INSERT INTO book (BChineseName, BOriginName, BType, BRating, BRatingCount, BReleaseDate, BPublisher, AuthorId, " +
                "BPageCount, BBinding, BContent, BLanguage, BCover) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                book.getBChineseName(),book.getBOriginName(),book.getBType(),book.getBRating(),book.getBRatingCount(),book.getBReleaseDate(),book.getBPublisher(),book.getAuthorId(),
                book.getbPageCount(),book.getbBinding(),book.getbContent(),book.getbLanguage(),book.getbCover());
    }

    @Override
    public int modifyBookById(Book book) {
        return executeUpdate(" UPDATE book" +
                " SET BChineseName = ?,BOriginName  = ?,BType = ?,BRating = ?,BRatingCount = ?,BReleaseDate = ?,BPublisher = ?,AuthorId = ?,BPageCount = ?,BBinding = ?,BContent = ?,BLanguage = ?,BCover = ?" +
                " WHERE BId = ?",book.getBChineseName(),book.getBOriginName(),book.getBType(),book.getBRating(),book.getBRatingCount(),book.getBReleaseDate(),book.getBPublisher(),book.getAuthorId(),
                book.getbPageCount(),book.getbBinding(),book.getbContent(),book.getbLanguage(),book.getbCover(),book.getBId());



    }

    @Override
    public int modifyBookAuthorByBookId(int bookId, int authorId) {
        return executeUpdate("UPDATE book SET AuthorId = ? WHERE BId = ?",authorId,bookId);
    }

    @Override
    public List<Book> getRecommandBooks() throws SQLException {
        int[] temp = {1,1,2,3,4,5,6};
        String sql = "select * from book where BId in (?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Book>(Book.class), temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
    }

    @Override
    public List<Book> getBookByLikeName(String name) throws SQLException{
        String sql = "select * from book where BChineseName like ? or BOriginName like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Book>(Book.class), "%"+name+"%", "%"+name+"%");
    }

    /**
     * TODO:根据类型检索图书
     * */
    public List<Book> getBookByType(String type){
        String sql = "select * from Book where BType like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql,new BeanListHandler<Book>(Book.class),"%"+type+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}