package team.sdguys.service.impl;

import team.sdguys.dao.UserDao;
import team.sdguys.dao.impl.UserDaoImpl;
import team.sdguys.entity.User;
import team.sdguys.service.UserService;
import team.sdguys.util.EmailUtil;
import team.sdguys.util.RandomUtil;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * UserService 的实现类
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean validateEmailIsAvailable(String email) {
        List<String> emailList = userDao.getEmailList();

        // 表中没有数据时
        if(emailList.size() == 0) {
            return false;
        }
        for(String e : emailList){
            // email 已经注册过
            if(email.equals(e)){
                return true;
            }
        }
        // email 未注册过
        return false;
    }

    @Override
    public boolean validateLoginPassword(String email, String password) {
        String result = userDao.getPasswordByEmail(email);
        if(result.equals(password)){
            // 密码正确
            return true;
        }else{
            // 密码错误
            return false;
        }
    }

    @Override
    public String sendVerificationCode(String email) {
        // 生成验证码
        String verificationCode = RandomUtil.generateVerificationCode(6);
        try {
        // 发送验证码
            EmailUtil.sendEmail(email,verificationCode);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return verificationCode;
    }

    @Override
    public void registerUser(User user) {
        userDao.insertAUser(user);
    }

    @Override
    public int findUidByEmail(String email) {
        return userDao.getUidByEmail(email);
    }

    @Override
    public boolean validateVerificationCode(String code1, String code2) {
        if(code1.equals(code2)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int resetPassword(String email, String password) {
        int uid = userDao.getUidByEmail(email);
        int result = userDao.updatePasswordByUid(uid,password);
        return result;
    }

    @Override
    public User findUserByUid(int uid) {
        return userDao.getUserByUid(uid);
    }

    @Override
    public int resetUserName(String Username, int uid) {
        return userDao.resetUserName(Username,uid);
    }
}
