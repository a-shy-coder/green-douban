package team.sdguys.servlet.movie;

import team.sdguys.service.MovieReplyService;
import team.sdguys.service.impl.MovieReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMovieReplyServlet")
public class DeleteMovieReplyServlet extends HttpServlet {

    MovieReplyService movieReplyService = new MovieReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  movieReplyId = Integer.parseInt(req.getParameter("movieReplyId"));
        int rows = movieReplyService.deleteMovieReplyByMovieReplyId(movieReplyId);
    }
}
