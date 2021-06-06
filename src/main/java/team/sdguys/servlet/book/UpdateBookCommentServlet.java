package team.sdguys.servlet.book;

import team.sdguys.service.BookCommentService;
import team.sdguys.service.impl.BookCommentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 更新图书评论的Servlet
 */
@WebServlet("/updateBookCommentServlet")
public class UpdateBookCommentServlet extends HttpServlet {
    BookCommentService bookCommentService = new BookCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("uid");

        int bcid = Integer.parseInt(request.getParameter("bcid"));
        String bcContent = request.getParameter("bcContent");
        int result = bookCommentService.updateComment(bcid,uid,bcContent);
        response.getWriter().write(result);
    }
}
