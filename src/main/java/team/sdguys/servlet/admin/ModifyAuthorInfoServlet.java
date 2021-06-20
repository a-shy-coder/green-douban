package team.sdguys.servlet.admin;

import team.sdguys.entity.Author;
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

@WebServlet("/modifyAuthorInfoServlet")
public class ModifyAuthorInfoServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Author author = authorService.findAuthorByAuthorId(authorId);
        req.setAttribute("author",author);

        req.getRequestDispatcher("jsp/admin/modifyAuthorInfo.jsp").forward(req,resp);

    }
}
