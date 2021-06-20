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

@WebServlet("/checkMovieActorServlet")
public class CheckMovieActorServlet extends HttpServlet {

    MovieService movieService = new MovieServiceImpl();
    ActorService actorService = new ActorServiceImpl();
    MovieActorService movieActorService = new MovieActorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        int actorId = Integer.parseInt(req.getParameter("actorId"));

        boolean result = false;
        List<Actor> actorList = actorService.getActorList();
        for (Actor actor : actorList) {
            if(actor.getActorId() == actorId){
                result = true;
                break;
            }
        }
        // 存在该演员
        if(result == true){
            List<Integer> actorIdList = movieActorService.findActorIdListByMovieId(movieId);
            for(int id:actorIdList){
                // 该演员已经被添加到电影中
                if(id == actorId){
                    result = false;
                }
            }
        }


        resp.getWriter().write(String.valueOf(result));
    }
}
