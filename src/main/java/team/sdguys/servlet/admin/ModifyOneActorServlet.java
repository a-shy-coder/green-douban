package team.sdguys.servlet.admin;

import team.sdguys.entity.Actor;
import team.sdguys.service.ActorService;
import team.sdguys.service.impl.ActorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyOneActorServlet")
public class ModifyOneActorServlet extends HttpServlet {

    ActorService actorService = new ActorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String chineseName = req.getParameter("chineseName");
        String originName = req.getParameter("originName");
        String cover = req.getParameter("cover");
        String gender = req.getParameter("gender");
        String content = req.getParameter("content");

        Actor actor = new Actor(id,chineseName,originName,content,gender,cover);
        int rows = actorService.modifyActorById(actor);
    }
}