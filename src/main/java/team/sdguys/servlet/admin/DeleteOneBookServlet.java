package team.sdguys.servlet.admin;

import team.sdguys.service.impl.BookManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dobs")
public class DeleteOneBookServlet extends HttpServlet {

    BookManagerServiceImpl bookManagerServiceImpl=new BookManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求参数
        //获取要删除的图书的编号
        String bid = req.getParameter("bid");

        //2. 执行业务逻辑
        //根据学号从数据库删除学生
        bookManagerServiceImpl.deleteBookById(Integer.parseInt(bid));

        //3. 生成响应内容，因为这里删除学生使用ajax发送的请求，不打算给任何响应数据，所以就没打印响应内容
    }
}