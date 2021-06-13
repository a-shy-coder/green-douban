package team.sdguys.servlet.admin;

import team.sdguys.service.AdminService;
import team.sdguys.service.UserService;
import team.sdguys.service.impl.AdminServiceImpl;
import team.sdguys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录成功请求的Servlet
 */
@WebServlet("/adminLoginServlet")
public class LoginServlet extends HttpServlet {

   AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        int aid = adminService.findAidByUserName(username);
        System.out.println(aid);
        // 将uid放入会话, 方便其他页面获取相关信息
        HttpSession session = req.getSession(false);
        session.setAttribute("aid",aid);
        System.out.println("aid: " + session.getAttribute("aid"));
        // 登录成功后 跳转主页....
    }
}
