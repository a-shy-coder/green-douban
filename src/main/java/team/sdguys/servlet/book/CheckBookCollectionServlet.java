package team.sdguys.servlet.book;

import team.sdguys.service.BookCollectionService;
import team.sdguys.service.impl.BookCollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查当前用户是否收藏该图书的Servlet
 */
@WebServlet("/checkBookCollectionServlet")
public class CheckBookCollectionServlet extends HttpServlet {

    BookCollectionService bookCollectionService = new BookCollectionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        Boolean result = bookCollectionService.checkRecordByUidAndBookId(uid,bookId);
        resp.getWriter().write(String.valueOf(result));
    }
}
