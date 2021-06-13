package team.sdguys.service;

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
}