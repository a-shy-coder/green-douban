package team.sdguys.dao.impl;

import team.sdguys.dao.DirectorDao;
import team.sdguys.entity.Director;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DirectorDao接口的实现类
 */
public class DirectorDaoImpl extends BaseDaoImpl implements DirectorDao {

    @Override
    public Director getDirectorByDirectorId(int DirectorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Director director = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Director Where DirectorId = ?");
            preparedStatement.setInt(1,DirectorId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                director = new Director(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return director;
    }
}
