package team.sdguys.servlet.book;

import team.sdguys.entity.BookComment;
import team.sdguys.entity.BookReply;
import team.sdguys.service.BookCommentService;
import team.sdguys.service.BookReplyService;
import team.sdguys.service.impl.BookCommentServiceImpl;
import team.sdguys.service.impl.BookReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 图书回复页面的Servlet
 */
@WebServlet("/bookReplyInfoServlet")
public class BookReplyInfoServlet extends HttpServlet {

    BookReplyService bookReplyService = new BookReplyServiceImpl();
    BookCommentService bookCommentService = new BookCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 评论编号
        int bcId = Integer.parseInt(req.getParameter("bookCommentId"));

        // 查找这条评论
        BookComment bookComment = bookCommentService.findBookCommentByBookCommentId(bcId);
        req.setAttribute("bookComment",bookComment);

        // 查找评论的所有回复
        List<BookReply> bookReplyList = bookReplyService.getBookReplyListByBookCommentId(bcId);
        req.setAttribute("bookReplyList",bookReplyList);

        req.getRequestDispatcher("jsp/book/bookReplyInfo.jsp").forward(req, resp);
    }
}
