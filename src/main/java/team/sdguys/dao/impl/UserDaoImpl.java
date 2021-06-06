package team.sdguys.dao.impl;

import team.sdguys.dao.UserDao;
import team.sdguys.entity.User;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public int insertAUser(User user) {
        return executeUpdate("insert into User (Uemail,Upassword,Uname) value (?,?,?)",user.getUemail(),user.getUpassword(),user.getUname());
    }

    @Override
    public List<String> getEmailList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();

        try{
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select Uemail from User");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add((resultSet.getString(1)));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public String getPasswordByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String Upassword = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select Upassword from USER where Uemail = ?");
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())){
                Upassword = resultSet.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(resultSet,preparedStatement,connection);
        }
        return Upassword;

    }

    @Override
    public User getUserByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from USER where Uid=?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return user;
    }

    @Override
    public int getUidByEmail(String Email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Uid = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select Uid from USER where Uemail = ?");
            preparedStatement.setString(1,Email);
            resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())){
                Uid = resultSet.getInt(1);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(resultSet,preparedStatement,connection);
        }
        return Uid;
    }

    @Override
    public int updatePasswordByUid(int uid, String password) {
        return executeUpdate("update user set Upassword = ? where Uid = ?", password,uid);
    }
}
