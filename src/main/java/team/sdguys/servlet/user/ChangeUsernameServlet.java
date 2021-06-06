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

@WebServlet("/ChangeName")
public class ChangeUsernameServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String username = request.getParameter("username");
        HttpSession session = request.getSession();

        int uid = (int) session.getAttribute("uid");
        int result = userService.resetUserName(username,uid);
        response.getWriter().write(result);

    }
}
