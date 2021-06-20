package team.sdguys.servlet.admin;

import team.sdguys.entity.Director;
import team.sdguys.entity.Movie;
import team.sdguys.service.DirectorService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.DirectorServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkMovieDirectorServlet")
public class CheckMovieDirectorServlet extends HttpServlet {

    MovieService movieService = new MovieServiceImpl();
    DirectorService directorService = new DirectorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        int directorId = Integer.parseInt(req.getParameter("directorId"));

        boolean result = false;
        List<Director> directorList = directorService.getDirectorList();
        for(Director director : directorList){
            if(director.getDirectorId() == directorId){
                result = true;
                break;
            }
        }
        if(result == true){
            Movie movie = movieService.findMovieById(movieId);
            System.out.println(directorId + " " + movie.getDirectorId());
            if(movie.getDirectorId() != directorId){
                result = true;
            }else{
                result = false;
            }
        }



        resp.getWriter().write(String.valueOf(result));
    }
}
