package team.sdguys.servlet.user;

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
 * 验证验证码是否正确的Servlet
 */
@WebServlet("/validateVerificationCodeServlet")
public class ValidateVerificationCodeServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String verificationCode = req.getParameter("verificationCode");
        HttpSession session = req.getSession(false);
        String correctCode = (String) session.getAttribute("verificationCode");
        boolean result = userService.validateVerificationCode(verificationCode,correctCode);

        resp.getWriter().write(String.valueOf(result));
    }
}
