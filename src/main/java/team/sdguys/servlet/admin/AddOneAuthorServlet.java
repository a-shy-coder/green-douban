package team.sdguys.servlet.admin;

import team.sdguys.entity.Author;
import team.sdguys.entity.Director;
import team.sdguys.service.AuthorService;
import team.sdguys.service.DirectorService;
import team.sdguys.service.impl.AuthorServiceImpl;
import team.sdguys.service.impl.DirectorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addOneAuthorServlet")
public class AddOneAuthorServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String gender = req.getParameter("gender");
        String content = req.getParameter("content");

        Author author = new Author(chineseName,originName,content,gender,cover);
        int rows = authorService.addAuthor(author);
    }
}