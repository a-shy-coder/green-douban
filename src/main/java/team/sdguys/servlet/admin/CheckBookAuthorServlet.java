package team.sdguys.servlet.admin;

import team.sdguys.entity.Author;
import team.sdguys.entity.Book;
import team.sdguys.entity.Movie;
import team.sdguys.service.AuthorService;
import team.sdguys.service.BookService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.AuthorServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkBookAuthorServlet")
public class CheckBookAuthorServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();
    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int authorId = Integer.parseInt(req.getParameter("authorId"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));

        boolean result = false;
        List<Author> authorList = authorService.getAuthorList();
        for (Author author : authorList) {
            if(author.getAuthorId() == authorId){
                result = true;
                break;
            }
        }
        if(result == true){
            Book book = bookService.findBookById(bookId);
            if(book.getAuthorId() != authorId){
                result = true;
            }else{
                result = false;
            }
        }

        resp.getWriter().write(String.valueOf(result));
    }
}
