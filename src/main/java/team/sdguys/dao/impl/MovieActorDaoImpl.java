package team.sdguys.dao.impl;

import team.sdguys.dao.MovieActorDao;
import team.sdguys.entity.Director;
import team.sdguys.entity.MovieActor;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * MovieActorDao 接口的实现类
 */
public class MovieActorDaoImpl extends BaseDaoImpl implements MovieActorDao {

    @Override
    public List<Integer> getActorIdListByMovieId(int movieId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Integer> actorIdList = new ArrayList<Integer>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select actorId from movieactor Where MovieId = ?");
            preparedStatement.setInt(1,movieId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                actorIdList.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return actorIdList;
    }

    @Override
    public int insertNewMovieWithActorsInfo(MovieActor movieActor) {
        return executeUpdate("insert into MovieActor (MovieId,ActorId) value (?,?)", movieActor.getActorId()  ,movieActor.getMovieId() );
    }

    @Override
    public int deleteRecordByMovieIdAndActorId(int movieId, int actorId) {
        return executeUpdate("DELETE FROM movieactor WHERE MovieId = ? AND ActorId = ?",movieId,actorId);
    }

    @Override
    public int addMovieActor(int movieId, int actorId) {
        return executeUpdate("INSERT INTO movieactor (MovieId, ActorId) VALUES (?, ?)\n",movieId, actorId);
    }
}
