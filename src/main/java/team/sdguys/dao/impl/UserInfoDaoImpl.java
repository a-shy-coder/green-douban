package team.sdguys.dao.impl;

import team.sdguys.dao.BaseDao;
import team.sdguys.dao.UserInfoDao;
import team.sdguys.entity.UserInfo;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * UserInfoDao类，包含对UserInfo表的增删改查操作
 *
 * @author Mason
 */
public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao {

    /**
     * 插入一条新记录到表UserInfo中
     *
     * @param userInfo 包含要插入的信息的UserInfo对象
     * @return 一个整数值，标识是否插入成功，如果数字小于等于0，则表示插入失败，否则表示受影响的行数
     */
    @Override
    public int insert(UserInfo userInfo) {
        return executeUpdate("insert into UserInfo values(?,?,?,?,?,?)",userInfo.getUid(),userInfo.getUicon(),userInfo.getUgender(),userInfo.getUaddress(),userInfo.getUbirthday(),userInfo.getUsign());
    }

    /**
     * 更新一个用户信息，该方法允许修改除了Uid的用户信息
     *
     * @param userInfo 包含用户信息更新后的信息的UserInfo对象
     * @return 一个整数值，标识是否更新成功，如果数字小于等于0，则表示更新失败，否则表示受影响的行数
     */
    @Override
    public int update(UserInfo userInfo) {
        return executeUpdate("update userinfo set Uicon=?,Ugender=?,Uaddress=?,Ubirthday=?,Usign=? where Uid=?",userInfo.getUicon(),userInfo.getUgender(),userInfo.getUaddress(),userInfo.getUbirthday(),userInfo.getUsign(),userInfo.getUid());
    }

    /**
     * 从UserInfo表中删除指定Uid的用户的信息
     *
     * @param id 要删除的用户的Uid
     * @return 一个整数值，标识是否删除成功，若返回值大于0，表示受影响的行数，否则表示未删除任何记录
     */
    @Override
    public int delete(int id) {
        return executeUpdate("delete from UserInfo where Uid=?",id);
    }

    /**
     * 根据id查询单个用户的所有信息
     *
     * @param id 要查询的学生的学号
     * @return 包含所查询的学生的所有信息的userInfo对象
     */
    @Override
    public UserInfo getOneById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserInfo u = null;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from userInfo where Uid=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int Uid = rs.getInt(1);
                String Uicon = rs.getString(2);
                String Ugender = rs.getString(3);
                String Uaddress = rs.getString(4);
                String Ubirthday = rs.getString(5);
                String Usign = rs.getString(6);
                u = new UserInfo(Uid, Uicon, Ugender, Uaddress, Ubirthday, Usign);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return u;
    }

     /**
     * 查询男性用户的总人数
     *
     * @return 男性人数
     */
    @Override
    public int getManSize() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from userInfo where Ugender='男'");
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

    /**
     * 查询男性用户的总人数
     *
     * @return 女性人数
     */
    @Override
    public int getWomanSize() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select count(*) from userInfo where Ugender='女'");
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

    
     /**
     * 根据页码以及每页记录数查询用户信息列表
     *
     * @param pageNo 页码，也就是第几页，从1开始
     * @param pageSize 页面大小，也就是每页显示的记录数量
     * @return 所查询的学生的列表
     */
    @Override
    public List<UserInfo> getListByPage(int pageNo, int pageSize) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserInfo> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from UserInfo"
                    + "order by Uid OFFSET ? ROWS FETCH next ? rows only");
            ps.setInt(1, (pageNo-1)*pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int Uid = rs.getInt(1);
                String Uicon = rs.getString(2);
                String Ugender = rs.getString(3);
                String Uaddress = rs.getString(4);
                String Ubirthday = rs.getString(5);
                String Usign = rs.getString(6);
                UserInfo u = new UserInfo(Uid, Uicon, Ugender, Uaddress, Ubirthday, Usign);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    /**
     * 查询UserInfo表中所有学生的信息
     *
     * @return 包含所有信息的列表
     */
    @Override
    public List<UserInfo> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserInfo> list = new ArrayList();

        try {
            con = DataBaseUtil.getConnection();
            ps = con.prepareStatement("select * from userInfo");
            rs = ps.executeQuery();
            while (rs.next()) { //next()判断有没有下一行，并移动到下一行
                int Uid = rs.getInt(1);
                String Uicon = rs.getString(2);
                String Ugender = rs.getString(3);
                String Uaddress = rs.getString(4);
                String Ubirthday = rs.getString(5);
                String Usign = rs.getString(6);
                UserInfo u = new UserInfo(Uid, Uicon, Ugender, Uaddress, Ubirthday, Usign);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseUtil.close(rs, ps, con);
        }
        return list;
    }

    @Override
    public int insertUserInfoByUid(int uid) {
        return executeUpdate("INSERT userinfo(uid) values (?)",uid);
    }
}
