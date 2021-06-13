package team.sdguys.service.impl;

import team.sdguys.dao.AdminDao;
import team.sdguys.dao.impl.AdminDaoImpl;
import team.sdguys.entity.Admin;
import team.sdguys.entity.User;
import team.sdguys.service.AdminService;

import java.util.List;

/**
 * AdminService接口的实现类, 有关 Admin 业务的逻辑代码
 */
public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean validateUsernameIsAvailable(String username) {
        List<String> usernameList = adminDao.getAdminUsernameList();

        // 表中没有数据时
        if(usernameList.size() == 0) {
            return false;
        }
        for(String u : usernameList){
            // username 存在
            if(username.equals(u)){
                return true;
            }
        }
        // username 不存在
        return false;
    }

    @Override
    public boolean validateLoginPassword(String username, String password) {
        // 根据 username 获取 管理员 id
        int aid = adminDao.getAidByUsername(username);
        // 根据 id 获取密码
        Admin admin = adminDao.getAdminByAid(aid);
        String correctPassword = admin.getAPassword();
        if(correctPassword.equals(password)){
            // 密码正确
            return true;
        }else{
            // 密码错误
            return false;
        }
    }

    @Override
    public int findAidByUserName(String username) {
        return adminDao.getAidByUsername(username);
    }
}
