package team.sdguys.servlet.movie;

import team.sdguys.entity.Actor;
import team.sdguys.entity.Movie;
import team.sdguys.service.ActorService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.ActorServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 点击显示演员的相关信息
 */
@WebServlet("/actorInfoServlet")
public class ActorInfoServlet extends HttpServlet {
    
    ActorService actorService = new ActorServiceImpl();
    MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int actorId = Integer.parseInt(req.getParameter("actorId"));

        // 演员信息
        Actor actor = actorService.findActorByActorId(actorId);
        req.setAttribute("actor",actor);

        // 该演员拍摄的最新的5部电影
        List<Movie> latestMovieList = movieService.findTheLatest5MoviesByActorId(actorId);
        req.setAttribute("latestMovieList",latestMovieList);

        // 该演员拍摄的最受好评的5部电影
        List<Movie> popularMovieList = movieService.findTheTop5HighestRatedMoviesByActorId(actorId);
        req.setAttribute("popularMovieList",popularMovieList);

        req.getRequestDispatcher("jsp/movie/actorInfo.jsp").forward(req,resp);

    }
}
