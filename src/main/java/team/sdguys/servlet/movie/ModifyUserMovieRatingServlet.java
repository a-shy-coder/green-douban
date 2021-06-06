package team.sdguys.servlet.movie;

import com.google.gson.Gson;
import team.sdguys.entity.Movie;
import team.sdguys.service.MovieRatingService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.MovieRatingServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;
import team.sdguys.util.NumberFormatUtil;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改用户对电影评分的Servlet
 */

@WebServlet("/modifyUserMovieRatingServlet")
public class ModifyUserMovieRatingServlet extends HttpServlet {

    MovieRatingService movieRatingService = new MovieRatingServiceImpl();
    MovieService movieService = new MovieServiceImpl();

    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = Integer.parseInt(req.getParameter("uid"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        double rating = Double.parseDouble(NumberFormatUtil.reserveADecimalPlace(Double.parseDouble(req.getParameter("rating"))));

        // 修改电影总评分及评分人数
        movieService.modifyMovieRatingByMovieId(rating,movieId,uid);

        // 修改用户对电影评分
        int rows = movieRatingService.modifyMovieRating(uid,movieId,rating);



        Movie movie = movieService.findMovieById(movieId);

        // 电影评分及人数封装成JSON返回前端
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rating",movie.getMRating());
        map.put("ratingCount",movie.getMRatingCount());
        String mapJson = gson.toJson(map);
        resp.getWriter().write(mapJson);
    }
}
