package team.sdguys.servlet.admin;

import team.sdguys.entity.Admin;
import team.sdguys.service.AdminService;
import team.sdguys.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加管理员的Servlet
 */
@WebServlet("/addAdminServlet")
public class AddAdminServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminUserName = req.getParameter("userName");
        String adminPassword = req.getParameter("password");
        int rows = adminService.addAdmin(new Admin(adminUserName,adminPassword));
    }
}
