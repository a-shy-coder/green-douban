package team.sdguys.servlet.admin;

import team.sdguys.service.ActorService;
import team.sdguys.service.impl.ActorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOneActorServlet")
public class DeleteOneActorServlet extends HttpServlet {

    ActorService actorService = new ActorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int actorId = Integer.parseInt(req.getParameter("actorId"));

        //2. 执行业务逻辑
        int rows = actorService.deleteActorById(actorId);

    }
}