package team.sdguys.servlet.user;

import team.sdguys.entity.BookReply;
import team.sdguys.entity.MovieReply;
import team.sdguys.service.BookReplyService;
import team.sdguys.service.MovieReplyService;
import team.sdguys.service.impl.BookReplyServiceImpl;
import team.sdguys.service.impl.MovieReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 用户回复信息页面
 */
@WebServlet("/userReplyInfoServlet")
public class UserReplyInfoServlet extends HttpServlet {

    BookReplyService bookReplyService = new BookReplyServiceImpl();
    MovieReplyService movieReplyService = new MovieReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<BookReply> userBookReplyList = bookReplyService.findBookReplyListByUid(uid);
        List<MovieReply> userMovieReplyList = movieReplyService.findMovieReplyListByUid(uid);
        req.setAttribute("userBookReplyList",userBookReplyList);
        req.setAttribute("userMovieReplyList",userMovieReplyList);
    }
}
