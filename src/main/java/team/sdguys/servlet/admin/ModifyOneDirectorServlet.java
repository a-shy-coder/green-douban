package team.sdguys.servlet.admin;

import team.sdguys.entity.Director;
import team.sdguys.service.DirectorService;
import team.sdguys.service.impl.DirectorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyOneDirectorServlet")
public class ModifyOneDirectorServlet extends HttpServlet {

    DirectorService directorService = new DirectorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String gender = req.getParameter("gender");
        String content = req.getParameter("content");

        Director director = new Director(id,chineseName,originName,content,gender,cover);
        int rows = directorService.modifyDirectorById(director);
    }
}