package team.sdguys.servlet.book;

import team.sdguys.service.BookRatingService;
import team.sdguys.service.MovieRatingService;
import team.sdguys.service.impl.BookRatingServiceImpl;
import team.sdguys.service.impl.MovieRatingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取用户对图书的评分的Servlet
 */
@WebServlet("/getUserBookRatingServlet")
public class GetUserBookRatingServlet extends HttpServlet {

    BookRatingService bookRatingService = new BookRatingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = Integer.parseInt(req.getParameter("uid"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        double rating = bookRatingService.findBookRatingByUidAndBookId(uid,bookId);
        resp.getWriter().write(String.valueOf(rating/2));
    }
}
