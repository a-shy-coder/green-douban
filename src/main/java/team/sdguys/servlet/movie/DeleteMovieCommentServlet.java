package team.sdguys.servlet.movie;

import team.sdguys.service.MovieCommentService;
import team.sdguys.service.impl.MovieCommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 删除图书评论
 */
@WebServlet("/deleteMovieCommentServlet")
public class DeleteMovieCommentServlet extends HttpServlet {
    MovieCommentService movieCommentService = new MovieCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        int mcid = Integer.parseInt(request.getParameter("mcid"));
        HttpSession session = request.getSession();
        int result = movieCommentService.deleteComment(mcid);
        response.getWriter().write(result);
    }
}
