package team.sdguys.dao;

/**
 * BaseDao
 */
public interface BaseDao {

    /**
     * 执行指定的DML sql语句
     *
     * @param sql 要执行的sql语句
     * @param params sql语句需要的各个参数
     * @return 受影响的行数
     */
    int executeUpdate(String sql, Object... params);
}
