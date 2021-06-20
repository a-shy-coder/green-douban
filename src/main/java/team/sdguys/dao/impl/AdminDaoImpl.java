package team.sdguys.dao.impl;
import team.sdguys.dao.AdminDao;
import team.sdguys.entity.Admin;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AdminDaoImpl  extends  BaseDaoImpl implements  AdminDao{


    @Override
    public int insertAdmin(Admin admin) {
        return executeUpdate("insert into Admin (Aid, Ausername, Apassword) value (?,?,?)", admin.getAid(),admin.getAUsername(),admin.getAPassword());
    }

    @Override
    public List<String> getAdminUsernameList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList<>();
        try{
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select Ausername from ADMIN");
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
    public Admin getAdminByAid(int aid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from ADMIN where Aid=?");
            preparedStatement.setInt(1, aid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return admin;
    }

    @Override
    public int getAidByUsername(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int aid = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select Aid from Admin where Ausername = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                aid = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return aid;

    }

    @Override
    public int updateAdminByAid(Admin admin) {
        return executeUpdate("update Admin set Ausername=?, Apassword=? where Aid=?",admin.getAUsername(),admin.getAPassword(),admin.getAid());
    }

    @Override
    public List<Admin> getAdminList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        List<Admin> adminList = new ArrayList<Admin>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from ADMIN");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                adminList.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return adminList;
    }

    @Override
    public int addAdmin(Admin admin) {
        return executeUpdate("INSERT INTO admin (Ausername, Apassword) VALUES (?, ?)",admin.getAUsername(),admin.getAPassword());
    }

    @Override
    public int modifyAdminPasswordByAdminId(String adminPassword, int adminId) {
        return executeUpdate("UPDATE admin SET Apassword = ? WHERE Aid = ?",adminPassword,adminId);
    }

    @Override
    public int deleteAdminByAdminId(int adminId) {
        return executeUpdate("DELETE FROM admin WHERE Aid = ?",adminId);
    }

}
