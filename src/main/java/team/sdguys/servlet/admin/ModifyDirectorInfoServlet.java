package team.sdguys.servlet.admin;

import team.sdguys.entity.Director;
import team.sdguys.service.DirectorService;
import team.sdguys.service.DirectorService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.DirectorServiceImpl;
import team.sdguys.service.impl.DirectorServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyDirectorInfoServlet")
public class ModifyDirectorInfoServlet extends HttpServlet {

    DirectorService directorService = new DirectorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int directorId = Integer.parseInt(req.getParameter("directorId"));
        Director director = directorService.findDirectorByDirectorId(directorId);
        req.setAttribute("director",director);

        req.getRequestDispatcher("jsp/admin/modifyDirectorInfo.jsp").forward(req,resp);

    }
}
