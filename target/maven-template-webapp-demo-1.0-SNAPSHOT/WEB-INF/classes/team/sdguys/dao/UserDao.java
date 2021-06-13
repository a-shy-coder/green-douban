package team.sdguys.dao;

import team.sdguys.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户表接口, 针对用户表的一些操作
 */
public interface UserDao extends BaseDao{

    /**
     * 向 User表中 插入一条用户记录
     * @param user 待插入的 用户实体
     * @return 受影响的行数
     */
    int insertAUser(User user);

    /**
     * 检索当前所有已注册邮箱列表
     * @return 邮箱列表
     */
    List<String> getEmailList();

    /**
     * 根据 邮箱 检索出 密码
     * @param email 邮箱
     * @return 密码
     */
    String getPasswordByEmail(String email);

    /**
     * 根据 uid 检索出 用户信息(邮箱, 密码, 昵称)
     * @param uid 待检索的用户 uid
     * @return user 对象
     */
    User getUserByUid(int uid);

    /**
     * 根据 email 检索出 用户id
     * @param Email 邮箱
     * @return 用户id
     */
    int getUidByEmail(String Email);

    /**
     * 根据 Uid 更新用户密码
     * @param uid 用户id
     * @param password 用户密码
     * @return 受影响的行数
     */
    int updatePasswordByUid(int uid, String password);

    /**
     * 修改用户名
     */
    int resetUserName(String Username,int uid);
}
