package team.sdguys.servlet.user;

import team.sdguys.entity.Book;
import team.sdguys.entity.BookComment;
import team.sdguys.entity.Movie;
import team.sdguys.entity.MovieComment;
import team.sdguys.service.*;
import team.sdguys.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户评论信息页面
 */
@WebServlet("/userCommentInfoServlet")
public class UserCommentInfoServlet extends HttpServlet {

    BookCommentService bookCommentService = new BookCommentServiceImpl();
    MovieCommentService movieCommentService = new MovieCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<BookComment> userBookCommentList = bookCommentService.findBookCommentListByUid(uid);
        List<MovieComment> userMovieCommentList = movieCommentService.findMovieCommentListByUid(uid);
        req.setAttribute("userBookCommentList",userBookCommentList);
        req.setAttribute("userMovieCommentList",userMovieCommentList);
        req.getRequestDispatcher("jsp/user/userCommentInfo.jsp").forward(req,resp);
    }
}
