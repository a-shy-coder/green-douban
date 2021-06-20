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
 * 修改管理员的Servlet
 */
@WebServlet("/modifyAdminServlet")
public class ModifyAdminServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int adminId = Integer.parseInt(req.getParameter("adminId"));
        String adminPassword = req.getParameter("adminPassword");
        adminService.modifyAdminPasswordByAdminId(adminPassword,adminId);
    }
}
