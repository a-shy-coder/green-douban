package team.sdguys.servlet.admin;

import team.sdguys.service.AuthorService;
import team.sdguys.service.impl.AuthorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOneAuthorServlet")
public class DeleteOneAuthorServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int authorId = Integer.parseInt(req.getParameter("authorId"));

        //2. 执行业务逻辑
        int rows = authorService.deleteAuthorById(authorId);

    }
}