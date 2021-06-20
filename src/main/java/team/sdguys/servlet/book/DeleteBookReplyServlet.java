package team.sdguys.servlet.book;

import team.sdguys.service.BookReplyService;
import team.sdguys.service.impl.BookReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBookReplyServlet")
public class DeleteBookReplyServlet extends HttpServlet {

    BookReplyService bookReplyService = new BookReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  bookReplyId = Integer.parseInt(req.getParameter("bookReplyId"));
        int rows = bookReplyService.deleteBookReplyByBookReplyId(bookReplyId);
    }
}
