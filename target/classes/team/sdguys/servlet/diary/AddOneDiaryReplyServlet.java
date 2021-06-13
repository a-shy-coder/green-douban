package team.sdguys.servlet.diary;

import team.sdguys.entity.DiaryReply;
import team.sdguys.service.DiaryReplyService;
import team.sdguys.service.impl.DiaryReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

/**
 * 添加日志评论的Servlet
 */
@WebServlet("/addOneDiaryReplyServlet")
public class AddOneDiaryReplyServlet extends HttpServlet {

    DiaryReplyService diaryReplyService = new DiaryReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        int drfromid = Integer.parseInt(request.getParameter("drfromid"));
        int drtoid = Integer.parseInt(request.getParameter("drtoid"));
        String drcontent = request.getParameter("drcontent");
        Date date = Date.valueOf(request.getParameter("date"));
        int did = Integer.parseInt(request.getParameter("did"));
        int dcid = Integer.parseInt(request.getParameter("dcid"));
        DiaryReply diaryReply = new DiaryReply(drfromid,drtoid,drcontent,date,did,dcid,0);
        int result = diaryReplyService.addoneDiaryReply(diaryReply);
        response.getWriter().write(result);

    }
}
