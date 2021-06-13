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
 * 发送验证码的Servlet
 */
@WebServlet("/sendVerificationCodeServlet")
public class SendVerificationCodeServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        String verificationCode = userService.sendVerificationCode(email);
        HttpSession session = req.getSession(false);
        session.setAttribute("verificationCode",verificationCode);
        System.out.println("会话中的验证码:" + session.getAttribute("verificationCode"));
    }
}
