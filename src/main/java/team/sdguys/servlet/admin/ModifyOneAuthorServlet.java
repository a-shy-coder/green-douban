package team.sdguys.servlet.admin;

import team.sdguys.entity.Author;
import team.sdguys.service.AuthorService;
import team.sdguys.service.impl.AuthorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyOneAuthorServlet")
public class ModifyOneAuthorServlet extends HttpServlet {

    AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String gender = req.getParameter("gender");
        String content = req.getParameter("content");

        Author author = new Author(id,chineseName,originName,content,gender,cover);
        int rows = authorService.modifyAuthorById(author);
    }
}