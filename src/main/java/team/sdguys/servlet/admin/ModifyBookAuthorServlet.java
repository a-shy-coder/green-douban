package team.sdguys.servlet.admin;

import team.sdguys.service.BookService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.BookServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyBookAuthorServlet")
public class ModifyBookAuthorServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int rows = bookService.modifyBookAuthorByBookId(bookId, authorId);
    }
}
