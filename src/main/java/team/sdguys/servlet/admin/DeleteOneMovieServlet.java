package team.sdguys.servlet.admin;

import team.sdguys.service.MovieService;
import team.sdguys.service.impl.MovieManagerServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOneMovieServlet")
public class DeleteOneMovieServlet extends HttpServlet {

    MovieManagerServiceImpl movieManagerServiceImpl = new MovieManagerServiceImpl();
    MovieService movieService = new MovieServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求参数
        //获取要删除的电影的编号
        int mid = Integer.parseInt(req.getParameter("movieId"));

        //2. 执行业务逻辑
        movieService.deleteMovieByMovieId(mid);
    }
}
