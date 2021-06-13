package team.sdguys.servlet.book;

import com.google.gson.Gson;
import team.sdguys.entity.Book;
import team.sdguys.service.BookRatingService;
import team.sdguys.service.BookService;
import team.sdguys.service.impl.BookRatingServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;
import team.sdguys.util.NumberFormatUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改用户对图书评分的Servlet
 */

@WebServlet("/modifyUserBookRatingServlet")
public class ModifyUserBookRatingServlet extends HttpServlet {

    BookRatingService bookRatingService = new BookRatingServiceImpl();
    BookService bookService = new BookServiceImpl();

    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = Integer.parseInt(req.getParameter("uid"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        double rating = Double.parseDouble(NumberFormatUtil.reserveADecimalPlace(Double.parseDouble(req.getParameter("rating"))));


        // 修改图书总评分及评分人数
        bookService.modifyBookRatingByBookId(rating,bookId,uid);

        // 修改用户对图书评分
        int rows = bookRatingService.modifyBookRating(uid,bookId,rating);



        Book book = bookService.findBookById(bookId);

        // 图书评分及人数封装成JSON返回前端
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rating",book.getBRating());
        map.put("ratingCount",book.getBRatingCount());
        String mapJson = gson.toJson(map);
        resp.getWriter().write(mapJson);
    }
}
