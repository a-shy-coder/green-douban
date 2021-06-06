package team.sdguys.servlet.diary;

import team.sdguys.service.DiaryReplyService;
import team.sdguys.service.impl.DiaryReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 删除日志评论的Servlet
 */
@WebServlet("/deleteOneDiaryReplyService")
public class DeleteOneDiaryReplyServlet extends HttpServlet {

    DiaryReplyService diaryReplyService = new DiaryReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        int drid = Integer.parseInt(request.getParameter("drid"));
        int result = diaryReplyService.deleteoneDiaryReply(drid,uid);
        response.getWriter().write(result);
    }
}
