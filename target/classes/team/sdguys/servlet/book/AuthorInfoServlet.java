package team.sdguys.servlet.book;

import team.sdguys.entity.Author;
import team.sdguys.entity.Book;
import team.sdguys.service.AuthorService;
import team.sdguys.service.BookService;
import team.sdguys.service.impl.AuthorServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 点击显示作者的相关信息
 */
@WebServlet("/authorInfoServlet")
public class AuthorInfoServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int authorId = Integer.parseInt(req.getParameter("authorId"));

        // 作者信息
        Author author = authorService.findAuthorByAuthorId(authorId);
        req.setAttribute("author",author);

        // 该作者出版的最新的5部图书
        List<Book> latestBookList = bookService.findTheLatest5BooksByAuthorId(authorId);
        req.setAttribute("latestBookList",latestBookList);

        // 该作者写作的最受好评的5部图书
        List<Book> popularBookList = bookService.findTheTop5HighestRatedBooksByAuthorId(authorId);
        req.setAttribute("popularBookList",popularBookList);

        req.getRequestDispatcher("jsp/book/authorInfo.jsp").forward(req,resp);

    }
}
