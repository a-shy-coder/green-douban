package team.sdguys.servlet.movie;

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

/**
 * 点击导演显示导演的详细信息
 */
@WebServlet("/directorInfoServlet")
public class DirectorInfoServlet extends HttpServlet {

    DirectorService directorService = new DirectorServiceImpl();
    MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int directorId = Integer.parseInt(req.getParameter("directorId"));

        // 导演信息
        Director director = directorService.findDirectorByDirectorId(directorId);
        req.setAttribute("director",director);

        // 该导演拍摄的最新的5部电影
        List<Movie> latestMovieList = movieService.findTheLatest5MoviesByDirectorId(directorId);
        req.setAttribute("latestMovieList",latestMovieList);

        // 该导演拍摄的最受好评的5部电影
        List<Movie> popularMovieList = movieService.findTheTop5HighestRatedMoviesByDirectorId(directorId);
        req.setAttribute("popularMovieList",popularMovieList);

        req.getRequestDispatcher("jsp/movie/directorInfo.jsp").forward(req,resp);

    }
}
