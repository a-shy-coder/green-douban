package team.sdguys.servlet.movie;

import team.sdguys.service.MovieRatingService;
import team.sdguys.service.impl.MovieRatingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取用户对电影的评分的Servlet
 */
@WebServlet("/getUserMovieRatingServlet")
public class GetUserMovieRatingServlet extends HttpServlet {

    MovieRatingService movieRatingService = new MovieRatingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        double rating = movieRatingService.findMovieRatingByUidAndMovieId(uid,movieId);
        resp.getWriter().write(String.valueOf(rating/2));
    }
}
