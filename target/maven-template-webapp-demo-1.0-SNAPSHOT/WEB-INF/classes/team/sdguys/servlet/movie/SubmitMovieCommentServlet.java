package team.sdguys.servlet.movie;

import com.google.gson.Gson;
import team.sdguys.entity.MovieComment;
import team.sdguys.service.MovieCommentService;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.UserService;
import team.sdguys.service.impl.MovieCommentServiceImpl;
import team.sdguys.service.impl.UserInfoServiceImpl;
import team.sdguys.service.impl.UserServiceImpl;
import team.sdguys.util.DateFormatUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 提交电影评论的Servlet
 */
@WebServlet("/submitMovieCommentServlet")
public class SubmitMovieCommentServlet extends HttpServlet {

    MovieCommentService movieCommentService = new MovieCommentServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();
    UserService userService = new UserServiceImpl();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        int uid = (int) session.getAttribute("uid");
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        String commentContent = (String) req.getParameter("commentContent");
        Date date = new Date();

        // 提交评论
        int movieCommentId = movieCommentService.submitMovieComment(new MovieComment(movieId,commentContent,uid, date,0));

        // 将多项信息以JSON格式返回给前端
        Map<String,Object> map = new HashMap<String,Object>();

        // 评论编号
        map.put("movieCommentId",movieCommentId);

        // 评论时间
        map.put("movieCommentTime", DateFormatUtil.formatDateTime(date));

        // 用户头像
        String userIcon = userInfoService.findUserInfoById(uid).getUicon();
        map.put("userIcon",userIcon);

        // 用户名
        String userName = userService.findUserByUid(uid).getUname();
        map.put("userName",userName);

        //用户ID
        map.put("id",uid);

        //评论内容
        map.put("commentContent",commentContent);

        //点赞数
        map.put("commentLikeCount",0);

        String mapJson = gson.toJson(map);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(mapJson);


    }
}
