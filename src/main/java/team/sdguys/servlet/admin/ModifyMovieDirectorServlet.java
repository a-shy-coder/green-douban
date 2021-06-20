package team.sdguys.servlet.admin;

import team.sdguys.service.MovieService;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyMovieDirectorServlet")
public class ModifyMovieDirectorServlet extends HttpServlet {

    MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int directorId = Integer.parseInt(req.getParameter("directorId"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        System.out.println(directorId + "    " + movieId);
        int rows = movieService.modifyMovieDirectorById(directorId, movieId);
    }
}
