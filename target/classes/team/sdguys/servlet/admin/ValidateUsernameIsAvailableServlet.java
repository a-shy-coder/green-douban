package team.sdguys.servlet.admin;

import team.sdguys.service.AdminService;
import team.sdguys.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证 该管理员用户是否存在的Servlet
 */
@WebServlet("/validateUsernameIsAvailableServlet")
public class ValidateUsernameIsAvailableServlet extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean result = adminService.validateUsernameIsAvailable(username);
        resp.getWriter().write(String.valueOf(result));
    }
}
