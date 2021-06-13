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
 * 验证邮箱是否可用的Servlet
 */
@WebServlet("/validateEmailIsAvailableServlet")
public class ValidateEmailIsAvailableServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        Boolean result = userService.validateEmailIsAvailable(email);
        resp.getWriter().write(String.valueOf(result));
    }
}
