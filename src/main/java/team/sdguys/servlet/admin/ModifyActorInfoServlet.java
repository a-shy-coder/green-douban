package team.sdguys.servlet.admin;

import team.sdguys.entity.Actor;
import team.sdguys.entity.Director;
import team.sdguys.entity.Movie;
import team.sdguys.service.ActorService;
import team.sdguys.service.DirectorService;
import team.sdguys.service.MovieActorService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.ActorServiceImpl;
import team.sdguys.service.impl.DirectorServiceImpl;
import team.sdguys.service.impl.MovieActorServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 修改演员信息的Servlet
 */
@WebServlet("/modifyActorInfoServlet")
public class ModifyActorInfoServlet extends HttpServlet {

    ActorService actorService = new ActorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int actorId = Integer.parseInt(req.getParameter("actorId"));
        Actor actor = actorService.findActorByActorId(actorId);
        req.setAttribute("actor",actor);

        req.getRequestDispatcher("jsp/admin/modifyActorInfo.jsp").forward(req,resp);

    }
}
