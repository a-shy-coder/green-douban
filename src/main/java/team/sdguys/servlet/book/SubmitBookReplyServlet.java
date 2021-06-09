package team.sdguys.servlet.book;

import com.google.gson.Gson;
import team.sdguys.entity.BookReply;
import team.sdguys.service.BookReplyService;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.UserService;
import team.sdguys.service.impl.BookReplyServiceImpl;
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
 * 提交图书回复的Servlet
 */
@WebServlet("/submitBookReplyServlet")
public class SubmitBookReplyServlet extends HttpServlet {

    BookReplyService bookReplyService = new BookReplyServiceImpl();
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

        int fromId = (int) session.getAttribute("uid");
        int toId = Integer.parseInt(req.getParameter("toId"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int bookCommentId = Integer.parseInt(req.getParameter("bookCommentId"));
        String commentContent = (String) req.getParameter("commentContent");
        Date date = new Date();

        // 提交回复
        int bookReplyId = bookReplyService.submitBookReply(new BookReply(fromId,toId,commentContent,date,bookId,bookCommentId,0));

        // 将多项信息以JSON格式返回给前端
        Map<String,Object> map = new HashMap<String,Object>();

        // 评论编号
        map.put("bookReplyId",bookReplyId);

        // 评论时间
        map.put("bookReplyTime", DateFormatUtil.formatDateTime(date));

        //fromID
        map.put("fromId",fromId);

        // from用户名
        String userName = userService.findUserByUid(fromId).getUname();
        map.put("fromUserName",userName);
        
        // from用户头像
        String fromUserIcon = userInfoService.findUserInfoById(fromId).getUicon();
        map.put("fromUserIcon",fromUserIcon);
        
        // toId
        map.put("toId",toId);
        
        // to用户名
        String toUserName = userService.findUserByUid(toId).getUname();
        map.put("toUserName",toUserName);

        //评论内容
        map.put("commentContent",commentContent);

        //点赞数
        map.put("commentLikeCount",0);

        String mapJson = gson.toJson(map);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(mapJson);


    }
}
