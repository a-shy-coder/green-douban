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
 * 修改图书评论
 */
@WebServlet("/updateMovieCommentServlet")
public class UpdateMovieCommentServlet extends HttpServlet {
    MovieCommentService movieCommentService = new MovieCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        int mcid = Integer.parseInt(request.getParameter("mcid"));
        String mcContent = request.getParameter("mcContent");
        int result = movieCommentService.updateComment(mcid,uid,mcContent);
        response.getWriter().write(result);
    }
}
