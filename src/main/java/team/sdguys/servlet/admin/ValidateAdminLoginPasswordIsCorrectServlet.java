package team.sdguys.servlet.admin;

import team.sdguys.dao.AdminDao;
import team.sdguys.service.AdminService;
import team.sdguys.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validateAdminLoginPasswordIsCorrectServlet")
public class ValidateAdminLoginPasswordIsCorrectServlet extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean result = adminService.validateLoginPassword(username,password);

        resp.getWriter().write(String.valueOf(result));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);
    }
}
