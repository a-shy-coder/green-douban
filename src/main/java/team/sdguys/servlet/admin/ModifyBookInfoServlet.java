package team.sdguys.servlet.admin;

import team.sdguys.entity.Actor;
import team.sdguys.entity.Author;
import team.sdguys.entity.Director;
import team.sdguys.entity.Book;
import team.sdguys.service.ActorService;
import team.sdguys.service.AuthorService;
import team.sdguys.service.DirectorService;
import team.sdguys.service.BookService;
import team.sdguys.service.impl.ActorServiceImpl;
import team.sdguys.service.impl.AuthorServiceImpl;
import team.sdguys.service.impl.DirectorServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 修改图书信息的Servlet
 */
@WebServlet("/modifyBookInfoServlet")
public class ModifyBookInfoServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));

        // 图书的基本信息
        Book book = bookService.findBookById(bookId);
        req.setAttribute("book",book);
        // 图书作者的信息
        int authorId = book.getAuthorId();
        Author author = authorService.findAuthorByAuthorId(authorId);
        req.setAttribute("author",author);

        req.getRequestDispatcher("jsp/admin/modifyBookInfo.jsp").forward(req,resp);

    }
}
