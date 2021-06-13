package team.sdguys.servlet.user;

import team.sdguys.service.UserService;
import team.sdguys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重置密码的Servlet
 */
@WebServlet("/resetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // 重置密码
        int result = userService.resetPassword(email, password);

        resp.getWriter().write(result);
    }
}
