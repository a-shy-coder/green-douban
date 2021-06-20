package team.sdguys.service;

import team.sdguys.entity.Admin;

import java.util.List;

/**
 * 针对 管理员的业务
 */
public interface AdminService {
    /**
     * 验证管理员用户名是否存在
     *
     * @param username 用户名
     * @return true 存在 false 不存在
     */
    public boolean validateUsernameIsAvailable(String username);

    /**
     * 验证管理员密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return true 正确 false 不正确
     */
    public boolean validateLoginPassword(String username, String password);

    /**
     * 根据 username 找出 aid
     * @param username 用户名
     * @return aid
     */
    public int findAidByUserName(String username);

    /**
     * 获取所有的管理员列表
     * @return 管理员列表
     */
    List<Admin> getAdminList();

    /**
     * 插入管理员用户
     * @param admin 管理员
     * @return 受影响的行数
     */
    int addAdmin(Admin admin);

    /**
     * 修改管理员密码
     * @param adminPassword
     * @param adminId
     */
     int modifyAdminPasswordByAdminId(String adminPassword, int  adminId);

    /**
     * 删除管理员账号
     * @param adminId
     * @return
     */
    int deleteAdminByAdminId(int adminId);
}