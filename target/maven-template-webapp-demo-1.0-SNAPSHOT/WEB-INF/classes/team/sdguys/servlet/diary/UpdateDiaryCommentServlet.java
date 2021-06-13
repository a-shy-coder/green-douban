package team.sdguys.servlet.diary;

import team.sdguys.service.DiaryCommentService;
import team.sdguys.service.impl.DiaryCommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 修改日志评论的Servlet
 */
@WebServlet("/updateDiaryCommentServlet")
public class UpdateDiaryCommentServlet extends HttpServlet {
    DiaryCommentService diaryCommentService = new DiaryCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        HttpSession session = request.getSession();

        int uid = (int) session.getAttribute("uid");
        int dcid = Integer.parseInt(request.getParameter("dcid"));
        String dcContent = request.getParameter("dcContent");
        int result = diaryCommentService.updateDiaryComment(dcContent,uid,dcid);
        response.getWriter().write(result);
    }
}
