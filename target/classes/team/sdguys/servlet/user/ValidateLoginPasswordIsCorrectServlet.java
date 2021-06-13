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
 * 验证登录输入的密码是否正确的 Servlet
 */
@WebServlet("/validateLoginPasswordIsCorrectServlet")
public class ValidateLoginPasswordIsCorrectServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean result = userService.validateEmailIsAvailable(email);
        if(result == true) {
            result = userService.validateLoginPassword(email,password);
        }
        resp.getWriter().write(String.valueOf(result));
    }
}
