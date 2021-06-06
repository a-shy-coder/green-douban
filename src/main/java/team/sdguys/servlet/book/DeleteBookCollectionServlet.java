package team.sdguys.servlet.book;

import team.sdguys.service.BookCollectionService;
import team.sdguys.service.MovieCollectionService;
import team.sdguys.service.impl.BookCollectionServiceImpl;
import team.sdguys.service.impl.MovieCollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除图书收藏的Servlet
 */
@WebServlet("/deleteBookCollectionServlet")
public class DeleteBookCollectionServlet extends HttpServlet {

    BookCollectionService bookCollectionService = new BookCollectionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int rows = bookCollectionService.deleteBookCollection(uid,bookId);
        resp.getWriter().write(rows);
    }
}
