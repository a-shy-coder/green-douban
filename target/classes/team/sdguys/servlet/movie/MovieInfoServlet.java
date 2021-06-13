package team.sdguys.servlet.movie;

import team.sdguys.entity.Actor;
import team.sdguys.entity.Director;
import team.sdguys.entity.Movie;
import team.sdguys.entity.MovieComment;
import team.sdguys.service.*;
import team.sdguys.service.impl.*;
import team.sdguys.util.NumberFormatUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 点击电影展示电影页面的详细信息
 */
@WebServlet("/movieInfoServlet")
public class MovieInfoServlet extends HttpServlet {

    MovieService movieService = new MovieServiceImpl();
    DirectorService directorService = new DirectorServiceImpl();
    MovieActorService movieActorService = new MovieActorServiceImpl();
    ActorService actorService = new ActorServiceImpl();
    MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
    MovieCommentService movieCommentService = new MovieCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String movieChineseName = req.getParameter("movieChineseName");
        System.out.println(movieChineseName);
        // 电影信息
        int movieId = movieService.findMovieIdByMovieChineseName(movieChineseName);
        System.out.println(movieId);
        Movie movie = movieService.findMovieById(movieId);
        movie.setMRating(Double.parseDouble(NumberFormatUtil.reserveADecimalPlace(movie.getMRating())));
        req.setAttribute("movie",movie);

        // 导演信息
        int directorId = movie.getDirectorId();
        Director director = directorService.findDirectorByDirectorId(directorId);
        req.setAttribute("director", director);

        // 演员信息
        List<Integer> actorIdList = movieActorService.findActorIdListByMovieId(movieId);

        List<Actor> actorList = actorService.findActorListByActorIdList(actorIdList);
        req.setAttribute("actorList",actorList);


        // 电影收藏信息
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<Integer> otherMovieIdList = movieCollectionService.findOtherMovieIdListByUid(uid,movieId);
        List<Movie> movieList = movieService.findMovieListByMovieIdList(otherMovieIdList);
        req.setAttribute("movieCollectionList", movieList);

        // 电影评论信息
        List<MovieComment> movieCommentList = movieCommentService.findMovieCommentListByMovieId(movieId);
        req.setAttribute("movieCommentList", movieCommentList);

        req.getRequestDispatcher( "jsp/movie/movieInfo.jsp").forward(req,resp);
    }
}
