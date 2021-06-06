package team.sdguys.servlet.movie;

import team.sdguys.service.MovieCollectionService;
import team.sdguys.service.impl.MovieCollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加电影收藏的Servlet
 */
@WebServlet("/addMovieCollectionServlet")
public class AddMovieCollectionServlet extends HttpServlet {

    MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        int rows = movieCollectionService.addMovieCollection(uid,movieId);
        resp.getWriter().write(rows);
    }
}
