package team.sdguys.servlet.movie;

import team.sdguys.service.MovieCollectionService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.MovieCollectionServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查当前用户是否收藏该电影的Servlet
 */
@WebServlet("/checkMovieCollectionServlet")
public class CheckMovieCollectionServlet extends HttpServlet {

    MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        Boolean result = movieCollectionService.checkRecordByUidAndMovieId(uid,movieId);
        resp.getWriter().write(String.valueOf(result));
    }
}
