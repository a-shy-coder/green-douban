package team.sdguys.servlet.admin;

import team.sdguys.service.BookService;
import team.sdguys.service.impl.BookManagerServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOneBookServlet")
public class DeleteOneBookServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求参数
        //获取要删除的图书的编号
        int bookId = Integer.parseInt(req.getParameter("bookId"));

        //2. 执行业务逻辑
        int rows = bookService.deleteBookById(bookId);

    }
}