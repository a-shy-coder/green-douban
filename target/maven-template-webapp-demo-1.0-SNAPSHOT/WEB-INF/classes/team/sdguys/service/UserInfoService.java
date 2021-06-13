package team.sdguys.service;

import team.sdguys.entity.UserInfo;

import java.util.List;

/**
 * 用户信息的Service层接口, 定义用户信息的相关业务
 */
public interface UserInfoService {
    
    /**
     * 查询所有用户信息的一个列表
     *
     * @return 一个List列表，包含所有用户信息
     */
    public List<UserInfo> findAllUserInfo();
    /**
     * 根据id查询单个用户的所有信息
     *
     * @param id 表示Uid
     * @return 一个UserInfo对象，包含所有信息
     */
    public UserInfo findUserInfoById(int id);

    /**
     * 根据Uid删除指定的用户信息
     *
     * @param id 字符串表示Uid
     * @return 一个整数，表示删除的行数，如果删除0行，则返回0
     */
    public int deleteUserInfoById(int id);

    /**
     * 插入一条用户信息
     *
     * @param UserInfo 一个UserInfo对象，包含了新加入的所有信息
     * @return 一个整数，表示插入的行数，如果插入0行，则返回0
     */
    public int newUserInfo(UserInfo UserInfo);

    /**
     * 修改已有的信息
     *
     * @param UserInfo 一个UserInfo对象，包含了新信息
     * @return 一个整数，表示更新的行数，如果更新0行，则返回0
     */
    public int modifyUserInfo(UserInfo UserInfo);

    /**
     * 根据页码、每页记录数 查询用户信息列表
     *
     * @param pageNo 页码，也就是第几页，从1开始
     * @param pageSize 页面大小，也就是每页显示的记录数量
     * @return 查询到的列表
     */
    public List<UserInfo> findUserInfoByPageNo(int pageNo, int pageSize);

    /**
     * 查询男性用户的总人数
     *
     * @return 查询到的数量
     */
    public int findManSize();

    /**
     * 查询女性用户的总人数
     *
     * @return 查询到的数量
     */
    public int findWomanSize();

    /**
     * 更改用户信息
     */
    public int resetUserInfo(UserInfo userInfo);

    /**
     * 插入用户信息(用户编号和默认头像)
     * @param uid 用户编号
     * @return 受影响的行数
     */
    int createUserInfoByUid(int uid);
}
