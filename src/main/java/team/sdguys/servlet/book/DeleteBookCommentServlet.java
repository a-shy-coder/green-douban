package team.sdguys.servlet.book;

import team.sdguys.service.BookCommentService;
import team.sdguys.service.impl.BookCommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 删除图书评论的Servlet
 */
@WebServlet("/deleteBookCommentServlet")

public class DeleteBookCommentServlet extends HttpServlet {
    BookCommentService bookCommentService = new BookCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        int bcid  = Integer.parseInt(request.getParameter("bcid"));
        int result = bookCommentService.deleteComment(bcid);
        response.getWriter().write(result);
    }
}
