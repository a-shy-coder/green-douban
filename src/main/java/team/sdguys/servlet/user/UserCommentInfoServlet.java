package team.sdguys.servlet.user;

import team.sdguys.entity.*;
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
    DiaryCommentService diaryCommentService = new DiaryCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<BookComment> userBookCommentList = bookCommentService.findBookCommentListByUid(uid);
        List<MovieComment> userMovieCommentList = movieCommentService.findMovieCommentListByUid(uid);
        List<DiaryComment> userDiaryCommentList = diaryCommentService.findDiaryCommentListByUid(uid);
        req.setAttribute("userBookCommentList",userBookCommentList);
        req.setAttribute("userMovieCommentList",userMovieCommentList);
        req.setAttribute("userDiaryCommentList",userDiaryCommentList);
        req.getRequestDispatcher("jsp/user/userCommentInfo.jsp").forward(req,resp);
    }
}
