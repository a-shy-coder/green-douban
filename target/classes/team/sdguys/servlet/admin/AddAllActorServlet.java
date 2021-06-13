package team.sdguys.servlet.admin;

import team.sdguys.entity.MovieActor;
import team.sdguys.service.MovieActorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAllActorServlet extends HttpServlet {

    MovieActorService movieActorService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取新添加的图书作者的信息，封装成一个Author对象

        String MovieId = req.getParameter("MovieId");
        String[] ActorIds = req.getParameterValues("ActorIds");

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        int rows=0;
        //获取图书的信息，封装成很多MovieActor对象


        //2. 执行业务逻辑
        //将新图书插入数据库
        for(String ActorId:ActorIds) {
            MovieActor movieActor= new MovieActor(Integer.parseInt(MovieId) , Integer.parseInt(ActorId));
            rows= movieActorService.addNewMovieWithActorInfo(movieActor);
        }

        //3. 生成响应内容，这里直接返回了受影响的行数，用于判断是否插入成功
        resp.getWriter().println(rows);
    }
}
