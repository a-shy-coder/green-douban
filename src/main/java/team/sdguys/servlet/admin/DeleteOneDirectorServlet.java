package team.sdguys.servlet.admin;

import team.sdguys.service.DirectorService;
import team.sdguys.service.impl.DirectorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOneDirectorServlet")
public class DeleteOneDirectorServlet extends HttpServlet {

    DirectorService directorService = new DirectorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int directorId = Integer.parseInt(req.getParameter("directorId"));

        //2. 执行业务逻辑
        int rows = directorService.deleteDirectorById(directorId);

    }
}