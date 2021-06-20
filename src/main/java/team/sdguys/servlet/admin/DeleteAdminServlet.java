package team.sdguys.servlet.admin;

import team.sdguys.service.AdminService;
import team.sdguys.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int adminId = Integer.parseInt(req.getParameter("adminId"));
        int rows = adminService.deleteAdminByAdminId(adminId);
        resp.getWriter().print(rows);
    }
}
