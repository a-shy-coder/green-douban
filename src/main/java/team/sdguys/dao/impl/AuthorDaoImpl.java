package team.sdguys.dao.impl;

import team.sdguys.dao.AuthorDao;
import team.sdguys.entity.Actor;
import team.sdguys.entity.Author;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
