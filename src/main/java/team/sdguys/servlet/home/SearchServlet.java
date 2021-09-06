package team.sdguys.servlet.home;

import team.sdguys.entity.*;
import team.sdguys.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    SearchServiceImpl searchService = new SearchServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("keyword");
        //电影、图书、演员、导演、作者
        List<Movie> movieList = searchService.getMovieByLikeName(name);
        List<Book> bookList = searchService.getBookByLikeName(name);
        List<Actor> actorList = searchService.getActorByLikeName(name);
        List<Author> authorList = searchService.getAuthorByLikeName(name);
        List<Director> directorList = searchService.getDirectorByLikeName(name);

        req.setAttribute("movieList", movieList);
        req.setAttribute("bookList", bookList);
        req.setAttribute("actorList", actorList);
        req.setAttribute("authorList", authorList);
        req.setAttribute("directorList", directorList);
        req.getRequestDispatcher("jsp/home/searchResult.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
