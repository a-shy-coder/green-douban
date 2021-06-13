package team.sdguys.test;

import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试数据库是否能连接成功
 */
public class DataBaseConnectionTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DataBaseUtil.getConnection();
        System.out.println("连接成功");
    }
}
