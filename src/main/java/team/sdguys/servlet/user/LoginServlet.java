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
import java.net.URLEncoder;

/**
 * 登录成功请求的Servlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        int uid = userService.findUidByEmail(email);
        System.out.println(uid);
        // 将uid user userInfo 放入会话, 方便其他页面获取相关信息
        UserInfo userInfo = userInfoService.findUserInfoById(uid);
        User user = userService.findUserByUid(uid);

        HttpSession session = req.getSession(true);

        session.setAttribute("uid",uid);
        session.setAttribute("user",user);
        session.setAttribute("userInfo",userInfo);

        System.out.println(session.getAttribute("uid"));

        // 登录成功后 跳转主页....
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("homeServlet");
    }
}
