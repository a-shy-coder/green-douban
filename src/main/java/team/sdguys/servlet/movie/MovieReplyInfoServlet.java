package team.sdguys.servlet.movie;

import team.sdguys.entity.MovieComment;
import team.sdguys.entity.MovieReply;
import team.sdguys.service.MovieCommentService;
import team.sdguys.service.MovieReplyService;
import team.sdguys.service.impl.MovieCommentServiceImpl;
import team.sdguys.service.impl.MovieReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影回复页面的Servlet
 */
@WebServlet("/movieReplyInfoServlet")
public class MovieReplyInfoServlet extends HttpServlet {

    MovieReplyService movieReplyService = new MovieReplyServiceImpl();
    MovieCommentService movieCommentService = new MovieCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 评论编号
        int mcId = Integer.parseInt(req.getParameter("movieCommentId"));

        // 查找这条评论
        MovieComment movieComment = movieCommentService.findMovieCommentByMovieCommentId(mcId);
        req.setAttribute("movieComment",movieComment);

        // 查找评论的所有回复
        List<MovieReply> movieReplyList = movieReplyService.getMovieReplyListByMovieCommentId(mcId);
        req.setAttribute("movieReplyList",movieReplyList);

        req.getRequestDispatcher("jsp/movie/movieReplyInfo.jsp").forward(req, resp);
    }
}
