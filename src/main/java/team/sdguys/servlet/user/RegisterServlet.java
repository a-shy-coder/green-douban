package team.sdguys.servlet.user;

import team.sdguys.entity.User;
import team.sdguys.entity.UserInfo;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.UserService;
import team.sdguys.service.impl.UserInfoServiceImpl;
import team.sdguys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 注册用 Servlet
 */

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");

        User user = new User(email,password,userName);
        userService.registerUser(user);
        int uid = userService.findUidByEmail(email);
        userInfoService.createUserInfoByUid(uid);
        // 将uid user userInfo 放入会话, 方便其他页面获取相关信息
        UserInfo userInfo = userInfoService.findUserInfoById(uid);

        HttpSession session = req.getSession(true);
        session.setAttribute("uid",uid);
        session.setAttribute("user",user);
        session.setAttribute("userInfo",userInfo);
        // 注册成功后跳转页面.....
    }
}
