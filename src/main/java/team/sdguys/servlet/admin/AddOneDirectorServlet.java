package team.sdguys.servlet.admin;

import team.sdguys.entity.Book;
import team.sdguys.entity.Director;
import team.sdguys.service.BookService;
import team.sdguys.service.DirectorService;
import team.sdguys.service.impl.BookServiceImpl;
import team.sdguys.service.impl.DirectorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addOneDirectorServlet")
public class AddOneDirectorServlet extends HttpServlet {

    DirectorService directorService = new DirectorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String gender = req.getParameter("gender");
        String content = req.getParameter("content");

        Director director = new Director(chineseName,originName,content,gender,cover);
        int rows = directorService.addDirector(director);
    }
}