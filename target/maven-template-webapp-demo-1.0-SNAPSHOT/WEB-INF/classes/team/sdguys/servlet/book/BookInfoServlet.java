package team.sdguys.servlet.book;

import team.sdguys.entity.*;
import team.sdguys.service.AuthorService;
import team.sdguys.service.BookCollectionService;
import team.sdguys.service.BookCommentService;
import team.sdguys.service.BookService;
import team.sdguys.service.impl.AuthorServiceImpl;
import team.sdguys.service.impl.BookCollectionServiceImpl;
import team.sdguys.service.impl.BookCommentServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookInfoServlet")
public class BookInfoServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    AuthorService authorService = new AuthorServiceImpl();
    BookCollectionService bookCollectionService = new BookCollectionServiceImpl();
    BookCommentService bookCommentService = new BookCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 书籍信息
        String bookChineseName = req.getParameter("bookChineseName");
        int bookId = bookService.findBookIdByBookChineseName(bookChineseName);
        Book book = bookService.findBookByBookId(bookId);
        req.setAttribute("book", book);

        // 作者信息
        int authorId = book.getAuthorId();
        Author author = authorService.findAuthorByAuthorId(authorId);
        req.setAttribute("author", author);

        // 图书收藏信息
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<Integer> otherBookIdList = bookCollectionService.findOtherBookIdListByUid(uid,bookId);
        List<Book> bookList = bookService.findBookListByBookIdList(otherBookIdList);
        req.setAttribute("bookCollectionList", bookList);

        //图书评论信息
        List<BookComment> bookCommentList = bookCommentService.findBookCommentListByBookId(bookId);
        req.setAttribute("bookCommentList", bookCommentList);


        req.getRequestDispatcher("jsp/book/bookInfo.jsp").forward(req,resp);

    }
}
