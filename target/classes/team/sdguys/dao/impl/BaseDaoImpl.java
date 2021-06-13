package team.sdguys.dao.impl;

import team.sdguys.dao.BaseDao;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * BaseDao接口的实现类
 */
public class BaseDaoImpl implements BaseDao {

    /**
     * 执行 DML(insert, update, delete) 操作
     * @param sql 要执行的sql语句
     * @param params sql语句需要的各个参数
     * @return 受影响的行数
     */
    @Override
    public int executeUpdate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0; i<params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
            rows = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(null, preparedStatement, connection);
        }
        return rows;
    }
}
