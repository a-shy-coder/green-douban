package team.sdguys.servlet.admin;

import team.sdguys.entity.Movie;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.MovieManagerServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addOneMovieServlet")
public class AddOneMovieServlet extends HttpServlet {

    MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String type = req.getParameter("type");
        Date releaseDate = null;
        try {
            releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("releaseDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String language = req.getParameter("language");
        String area = req.getParameter("area");
        String time = req.getParameter("time");
        String content = req.getParameter("content");

        Movie movie = new Movie(chineseName,originName,type,0,0,releaseDate,0,language,time,area,content,cover);
        int rows = movieService.addMovie(movie);
    }
}