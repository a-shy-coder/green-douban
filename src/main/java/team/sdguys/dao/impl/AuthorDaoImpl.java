package team.sdguys.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.sdguys.dao.AuthorDao;
import team.sdguys.entity.Actor;
import team.sdguys.entity.Author;
import team.sdguys.util.DataBaseUtil;
import team.sdguys.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AuthorDao 的 实现类
 */
public class AuthorDaoImpl extends BaseDaoImpl implements AuthorDao {

    @Override
    public Author getAuthorByAuthorId(int authorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Author author = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Author Where AuthorId = ?");
            preparedStatement.setInt(1,authorId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                author = new Author(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return author;
    }

    @Override
    public int insertNewAuthor(Author author) {
        return executeUpdate("insert into Author (AuthorId,AuthorChineseName,AuthorOriginName,AuthorInfo,AuthorGender,AuthorImg) value (?,?,?,?,?,?)", author.getAuthorId(), author.getAuthorChineseName(), author.getAuthorOriginName(), author.getAuthorInfo(), author.getAuthorGender(), author.getAuthorImg() );
    }

    @Override
    public List<Author> getAuthorList() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Author> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Author");
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int AuthorId = rs.getInt(1);
                String AuthorChineseName = rs.getString(2);
                String AuthorOriginName = rs.getString(3);
                String AuthorInfo = rs.getString(4);
                String AuthorGender = rs.getString(5);
                String AuthorImg = rs.getString(6);
                Author author = new Author(AuthorId, AuthorChineseName, AuthorOriginName, AuthorInfo, AuthorGender, AuthorImg);
                list.add(author);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int getAuthorCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from Author");
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
    public List<Author> getAuthorByPage(int pageNo, int defaultPageSize) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Author> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Author limit ?, ?");
            ps.setInt(1, (pageNo-1)*defaultPageSize);
            ps.setInt(2, defaultPageSize);               rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int AuthorId = rs.getInt(1);
                String AuthorChineseName = rs.getString(2);
                String AuthorOriginName = rs.getString(3);
                String AuthorInfo = rs.getString(4);
                String AuthorGender = rs.getString(5);
                String AuthorImg = rs.getString(6);
                Author author = new Author(AuthorId, AuthorChineseName, AuthorOriginName, AuthorInfo, AuthorGender, AuthorImg);
                list.add(author);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int deleteAuthorById(int authorId) {
        return executeUpdate("DELETE FROM author WHERE AuthorId = ?",authorId);
    }

    @Override
    public int addAuthor(Author author) {
        return executeUpdate("INSERT INTO author (AuthorChineseName, AuthorOriginName, AuthorInfo, AuthorGender, AuthorImg) VALUES (?, ?, ?, ?, ?)",
                author.getAuthorChineseName(),author.getAuthorOriginName(),author.getAuthorInfo(),author.getAuthorGender(),author.getAuthorImg());

    }

    @Override
    public int modifyAuthorById(Author author) {
        return executeUpdate("UPDATE author \n" +
                "        SET AuthorChineseName = ?,AuthorOriginName  = ?,AuthorInfo = ?,AuthorGender = ?,AuthorImg = ?\n" +
                "        WHERE AuthorId = ?",author.getAuthorChineseName(),author.getAuthorOriginName(),author.getAuthorInfo(),author.getAuthorGender(),author.getAuthorImg(),author.getAuthorId());
    }
    /**
     * @description TODO 根据作者名字进行模糊查询
     * */
    @Override
    public List<Author> getAuthorByLikeName(String name) throws SQLException {
        String sql = "select * from Author where AuthorChineseName like ? or AuthorOriginName like ?";
        QueryRunner runner =  new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Author>(Author.class), "%"+name+"%", "%"+name+"%");
    }
}

