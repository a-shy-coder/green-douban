package team.sdguys.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 用于 打开 关闭 数据库连接的工具类
 */
public class DataBaseUtil {
    private static final String DRIVER_CLASS;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("dbconfig");

    static {
        DRIVER_CLASS = RESOURCE_BUNDLE.getString("jdbc.driver");
        URL = RESOURCE_BUNDLE.getString("jdbc.url");
        USERNAME = RESOURCE_BUNDLE.getString("jdbc.username");
        PASSWORD = RESOURCE_BUNDLE.getString("jdbc.password");
    }

    /**
     * 打开数据库连接
     * @return 返回一个数据库连接对象 connection
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName(DRIVER_CLASS);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }

    /**
     * 关闭数据库连接: 依次关闭 结果集 语句 连接
     * @param resultSet 结果集
     * @param statement 语句
     * @param connection 连接
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if( null != resultSet){
                resultSet.close();
            }
            if( null != statement){
                statement.close();
            }
            if( null != connection){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
