package team.sdguys.dao;

import team.sdguys.entity.Admin;
import java.util.List;

/**
 * 管理员表接口, 针对管理员表的一些操作
 */
public interface AdminDao extends BaseDao{

    /**
     * 插入一条Admin管理员记录到Admin表中
     * @param admin 待插入的 管理员实体
     * @return 受影响的行数
     */
    int insertAdmin(Admin admin);

    /**
     * 检索当前所有管理员用户名列表
     * @return 用户名列表
     */
    List<String> getAdminUsernameList();


    /**
     * 根据aid检索Admin
     * @param aid 管理员编号
     * @return Admin
     */
    Admin getAdminByAid(int aid);

    /**
     * 根据 用户名 检索 管理员id
     * @param username 用户名
     * @return 管理员id
     */
    int getAidByUsername(String username);

    /**
     * 更新id为aid的管理员信息
     * @param admin 管理员
     * @return 受影响的行数
     */
    int updateAdminByAid(Admin admin);


}
