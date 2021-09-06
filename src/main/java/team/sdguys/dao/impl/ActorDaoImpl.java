package team.sdguys.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.sdguys.dao.ActorDao;
import team.sdguys.entity.Actor;
import team.sdguys.util.DataBaseUtil;
import team.sdguys.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Actor> getActorList() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Actor> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Actor");
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int ActorId = rs.getInt(1);
                String ActorChineseName = rs.getString(2);
                String ActorOriginName = rs.getString(3);
                String ActorInfo = rs.getString(4);
                String ActorGender = rs.getString(5);
                String ActorImg = rs.getString(6);
                Actor actor = new Actor(ActorId, ActorChineseName, ActorOriginName, ActorInfo, ActorGender, ActorImg);
                list.add(actor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int getActorCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from Actor");
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
    public List<Actor> getActorByPage(int pageNo, int defaultPageSize) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Actor> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Actor limit ?, ?");
            ps.setInt(1, (pageNo-1)*defaultPageSize);
            ps.setInt(2, defaultPageSize);
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int ActorId = rs.getInt(1);
                String ActorChineseName = rs.getString(2);
                String ActorOriginName = rs.getString(3);
                String ActorInfo = rs.getString(4);
                String ActorGender = rs.getString(5);
                String ActorImg = rs.getString(6);
                Actor actor = new Actor(ActorId, ActorChineseName, ActorOriginName, ActorInfo, ActorGender, ActorImg);
                list.add(actor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int deleteActorById(int actorId) {
        return executeUpdate("DELETE FROM actor WHERE ActorId = ?",actorId);

    }

    @Override
    public int addActor(Actor actor) {
        return executeUpdate("INSERT INTO actor (ActorChineseName, ActorOriginName, ActorInfo, ActorGender, ActorImg) VALUES (?, ?, ?, ?, ?)",
                actor.getActorChineseName(),actor.getActorOriginName(),actor.getActorInfo(),actor.getActorGender(),actor.getActorImg());
    }

    @Override
    public int modifyActorById(Actor actor) {
        return executeUpdate("UPDATE actor SET ActorChineseName = ?,ActorOriginName  = ?,ActorInfo = ?,ActorGender = ?,ActorImg = ? WHERE ActorId = ?",
                actor.getActorChineseName(),actor.getActorOriginName(),actor.getActorInfo(),actor.getActorGender(),actor.getActorImg(),actor.getActorId());
    }
    /**
     * @description TODO 根据演员的名字进行模糊查询
     * */
    @Override
    public List<Actor> getActorByLikeName(String name) throws SQLException {
        String sql = "select * from Actor where ActorChineseName like ? or ActorOriginName like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Actor>(Actor.class),"%"+name+"%","%"+name+"%");
    }
}
