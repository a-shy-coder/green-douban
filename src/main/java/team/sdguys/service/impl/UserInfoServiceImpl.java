package team.sdguys.service.impl;

import team.sdguys.dao.UserInfoDao;
import team.sdguys.dao.impl.UserInfoDaoImpl;
import team.sdguys.entity.UserInfo;
import team.sdguys.service.UserInfoService;

import java.util.List;

/**
 * UserInfoService接口的实现, 关于用户信息业务的相关逻辑
 */
public class UserInfoServiceImpl implements UserInfoService {

    UserInfoDao userInfoDao = new UserInfoDaoImpl();
    /**
     * 查询所有用户信息的一个列表
     *
     * @return 一个List列表，包含所有用户信息
     */
    @Override
    public List<UserInfo> findAllUserInfo() {
        return userInfoDao.getAll();
    }

    /**
     * 根据id查询单个用户的所有信息
     *
     * @param id 表示Uid
     * @return 一个UserInfo对象，包含所有信息
     */
    @Override
    public UserInfo findUserInfoById(int id) {
        return userInfoDao.getOneById(id);
    }

    /**
     * 根据Uid删除指定的用户信息
     *
     * @param id 字符串表示Uid
     * @return 一个整数，表示删除的行数，如果删除0行，则返回0
     */
    @Override
    public int deleteUserInfoById(int id) {
        return userInfoDao.delete(id);
    }

    /**
     * 插入一条用户信息
     *
     * @param UserInfo 一个UserInfo对象，包含了新加入的所有信息
     * @return 一个整数，表示插入的行数，如果插入0行，则返回0
     */
    @Override
    public int newUserInfo(UserInfo UserInfo) {
        return userInfoDao.insert(UserInfo);
    }

    /**
     * 修改已有的信息
     *
     * @param UserInfo 一个UserInfo对象，包含了新信息
     * @return 一个整数，表示更新的行数，如果更新0行，则返回0
     */
    @Override
    public int modifyUserInfo(UserInfo UserInfo) {
        return userInfoDao.update(UserInfo);
    }

    /**
     * 根据页码、每页记录数 查询用户信息列表
     *
     * @param pageNo 页码，也就是第几页，从1开始
     * @param pageSize 页面大小，也就是每页显示的记录数量
     * @return 查询到的列表
     */
    @Override
    public List<UserInfo> findUserInfoByPageNo(int pageNo, int pageSize) {
        return userInfoDao.getListByPage(pageNo, pageSize);
    }

    /**
     * 查询男性用户的总人数
     *
     * @return 查询到的数量
     */
    @Override
    public int findManSize() {
        return userInfoDao.getManSize();
    }

    /**
     * 查询女性用户的总人数
     *
     * @return 查询到的数量
     */
    @Override
    public int findWomanSize() {
        return userInfoDao.getWomanSize();
    }

    @Override
    public int resetUserInfo(UserInfo userInfo) {
        return userInfoDao.executeUpdate("update UserInfo set (Uicon,Ugender,Uaddress,Ubirthday,Usign) value (?,?,?,?,?)",userInfo.getUicon(),userInfo.getUgender(),userInfo.getUaddress(),userInfo.getUbirthday(),userInfo.getUsign());
    }
}
