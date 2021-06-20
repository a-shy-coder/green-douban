package team.sdguys.servlet.admin;

import team.sdguys.entity.Book;
import team.sdguys.entity.Movie;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addOneBookServlet")
public class AddOneBookServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String type = req.getParameter("type");
        Date releaseDate = null;
        try {
            releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("releaseDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String language = req.getParameter("language");
        String publisher = req.getParameter("publisher");
        int pageCount = Integer.parseInt(req.getParameter("pageCount"));
        String content = req.getParameter("content");
        String binding = req.getParameter("binding");

        Book book = new Book(chineseName,originName,type,0,0,releaseDate,publisher,pageCount,binding,content,language,cover);
        int rows = bookService.addBook(book);
    }
}