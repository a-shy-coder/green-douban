package team.sdguys.servlet.user;

import team.sdguys.entity.User;
import team.sdguys.service.UserService;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");

        User user = new User(email,password,userName);
        userService.registerUser(user);
        int uid = userService.findUidByEmail(email);
        HttpSession session = req.getSession(false);
        session.setAttribute("uid",uid);

        // 注册成功后跳转页面.....
    }
}
