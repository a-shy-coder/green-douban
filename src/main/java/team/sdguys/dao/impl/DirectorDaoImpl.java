package team.sdguys.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.sdguys.dao.DirectorDao;
import team.sdguys.entity.Director;
import team.sdguys.util.DataBaseUtil;
import team.sdguys.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Director> getDirectorList() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Director> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Director");
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int directorId = rs.getInt(1);
                String directorChineseName = rs.getString(2);
                String directorOriginName = rs.getString(3);
                String directorInfo = rs.getString(4);
                String directorGender = rs.getString(5);
                String directorImg = rs.getString(6);
                Director director = new Director(directorId, directorChineseName, directorOriginName, directorInfo, directorGender, directorImg);
                list.add(director);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public List<Director> getDirectorByPage(int pageNo, int defaultPageSize) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Director> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from Director limit ?, ?");
            ps.setInt(1, (pageNo-1)*defaultPageSize);
            ps.setInt(2, defaultPageSize);            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int directorId = rs.getInt(1);
                String directorChineseName = rs.getString(2);
                String directorOriginName = rs.getString(3);
                String directorInfo = rs.getString(4);
                String directorGender = rs.getString(5);
                String directorImg = rs.getString(6);
                Director director = new Director(directorId, directorChineseName, directorOriginName, directorInfo, directorGender, directorImg);
                list.add(director);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int getDirectorCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from Director");
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
    public int deleteDirectorById(int directorId) {
        return executeUpdate("DELETE FROM director WHERE DirectorId = ?",directorId);
    }

    @Override
    public int addDirector(Director director) {
        return executeUpdate("INSERT INTO director (DirectorChineseName, DirectorOriginName, DirectorInfo, DirectorGender, DirectorImg) VALUES (?, ?, ?, ?, ?)",
                director.getDirectorChineseName(),director.getDirectorOriginName(),director.getDirectorInfo(),director.getDirectorGender(),director.getDirectorImg());
    }

    @Override
    public int modifyDirectorById(Director director) {
        return executeUpdate("UPDATE Director \n" +
                "    SET DirectorChineseName = ?,DirectorOriginName  = ?, DirectorInfo = ?, DirectorGender = ?, DirectorImg = ? WHERE DirectorId = ?;",director.getDirectorChineseName(),director.getDirectorOriginName(),director.getDirectorInfo(),director.getDirectorGender(),director.getDirectorImg(),director.getDirectorId());
    }

    @Override
    public List<Director> getDirectorByLikeName(String name) throws SQLException {
        String sql = "select * from director where DirectorChineseName like ? or DirectorOriginName like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Director>(Director.class),"%"+name+"%", "%"+name+"%");
    }


}
