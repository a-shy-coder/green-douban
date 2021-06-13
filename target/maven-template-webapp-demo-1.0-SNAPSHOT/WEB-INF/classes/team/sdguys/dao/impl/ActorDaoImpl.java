package team.sdguys.dao.impl;

import team.sdguys.dao.ActorDao;
import team.sdguys.entity.Actor;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ActorDaoImpl extends BaseDaoImpl implements ActorDao {

    @Override
    public Actor getActorByActorId(int actorId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Actor actor = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Actor Where ActorId = ?");
            preparedStatement.setInt(1,actorId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                actor = new Actor(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return actor;
    }
}
