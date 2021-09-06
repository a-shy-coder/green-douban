package team.sdguys.servlet.home;

import team.sdguys.entity.Book;
import team.sdguys.entity.Diary;
import team.sdguys.entity.Movie;
import team.sdguys.service.impl.HomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
    HomeServiceImpl homeService = new HomeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //电影推荐
        List<Movie> recommendMovieList = homeService.getRecommendMovies();
        //图书推荐
        List<Book> recommendBookList = homeService.getRecommendBooks();
        //精选日志
        List<Diary> recommendDiaryList = homeService.getRecommendDiaries();

        req.setAttribute("recommendMovieList", recommendMovieList);
        req.setAttribute("recommendBookList", recommendBookList);
        req.setAttribute("recommendDiaryList", recommendDiaryList);

        req.getRequestDispatcher("jsp/home/home.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
