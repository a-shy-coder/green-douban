package team.sdguys.service;

import team.sdguys.entity.User;

/**
 * 针对 User 的相关业务
 */
public interface UserService {

    /**
     * 验证邮箱是否可用(登录时, 邮箱要已经注册过  注册时, 邮箱要未注册过)
     * @param email 登录/注册时输入的邮箱
     * @return 验证结果 true表示已经注册过
     */
    public boolean validateEmailIsAvailable(String email);

    /**
     * 验证登录时的密码是否正确(与邮箱是否对应)
     * @param email 登录时输入的邮箱
     * @param password 登录时输入的密码
     * @return 验证结果
     */
    public boolean validateLoginPassword(String email, String password);

    /**
     * 根据 邮箱 发送验证码
     * @param email 目标邮箱
     * @return 验证码
     */
    public String sendVerificationCode(String email);


    /**
     * 注册用户(将信息插入数据库)
     * @param user 待注册的用户
     * @return
     */
    public void registerUser(User user);


    /**
     * 根据邮箱找到对应的Uid
     * @param email 邮箱
     * @return Uid
     */
    public int findUidByEmail(String email);

    /**
     * 验证 验证码是否正确
     * @param code1: 用户输入的验证码
     * @param code2  正确的验证码(会话放入)
     * @return 验证结果
     */
    public boolean validateVerificationCode(String code1, String code2);


    /**
     * 重置用户的密码
     * @param email 用户的邮箱
     * @param password 新密码
     * @return 受影响的行数
     */
    public int resetPassword(String email, String password);

    /**
     * 通过uid找到User
     * @param uid 用户编号
     * @return User实体类
     */
    public User findUserByUid(int uid);

    /**
     * 修改用户名
     */
    public int resetUserName(String Username,int uid);
}
