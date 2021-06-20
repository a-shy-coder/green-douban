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
 * 修改电影信息的Servlet
 */
@WebServlet("/modifyMovieInfoServlet")
public class ModifyMovieInfoServlet extends HttpServlet {

    MovieService movieService = new MovieServiceImpl();
    MovieActorService movieActorService = new MovieActorServiceImpl();
    DirectorService directorService = new DirectorServiceImpl();
    ActorService actorService = new ActorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movieId"));

        // 电影的基本信息
        Movie movie = movieService.findMovieById(movieId);
        req.setAttribute("movie",movie);
        // 电影导演的信息
        int directorId = movie.getDirectorId();
        Director director = directorService.findDirectorByDirectorId(directorId);
        req.setAttribute("director",director);
        // 电影职员列表
        List<Integer> actorIdList = movieActorService.findActorIdListByMovieId(movieId);
        List<Actor> actorList = actorService.findActorListByActorIdList(actorIdList);
        req.setAttribute("actorList",actorList);
        for(int i=0; i<actorList.size(); i++){
            System.out.println(actorList.get(i).getActorChineseName());
        }
        req.getRequestDispatcher("jsp/admin/modifyMovieInfo.jsp").forward(req,resp);

    }
}
