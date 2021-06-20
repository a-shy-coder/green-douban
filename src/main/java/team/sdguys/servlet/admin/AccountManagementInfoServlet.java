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
import java.util.List;

/**
 * 管理员账号管理的信息页面
 */
@WebServlet("/accountManagementInfoServlet")
public class AccountManagementInfoServlet extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Admin> adminList = adminService.getAdminList();
        req.setAttribute("adminList",adminList);
        req.getRequestDispatcher("jsp/admin/adminAccountManagementInfo.jsp").forward(req,resp);
    }
}
