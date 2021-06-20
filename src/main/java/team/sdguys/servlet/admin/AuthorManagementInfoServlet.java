package team.sdguys.servlet.admin;

import team.sdguys.entity.Author;
import team.sdguys.entity.Book;
import team.sdguys.entity.Page;
import team.sdguys.service.AuthorService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.AuthorServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authorManagementInfoServlet")
public class AuthorManagementInfoServlet extends HttpServlet {
    AuthorService authorService = new AuthorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求参数
        String currentPageNo = req.getParameter("pageNo");

        //如果页面上没有提供pageNo这个参数，则查询第一页，否则查询指定页
        int pageNo = currentPageNo == null ? 1 : Integer.parseInt(currentPageNo);

        List<Author> authorList = authorService.findAuthorByPage(pageNo,Page.DEFAULT_PAGE_SIZE);
        int totalCount = authorService.getAuthorCount();

        // 将分页数据封装成一个Page对象，方便在页面上显示各项分页数据
        Page page=new Page(pageNo, authorList, totalCount);

        //3. 生成动态响应
        req.setAttribute("page", page);
        req.getRequestDispatcher("jsp/admin/authorManagement.jsp").forward(req, resp);

    }
}
