package team.sdguys.servlet.admin;

import team.sdguys.service.MovieActorService;
import team.sdguys.service.impl.MovieActorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMovieActorServlet")
public class DeleteMovieActorServlet extends HttpServlet {

    MovieActorService movieActorService = new MovieActorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int actorId = Integer.parseInt(req.getParameter("actorId"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        int rows = movieActorService.deleteRecordByMovieIdAndActorId(movieId,actorId);

    }
}
