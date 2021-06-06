package team.sdguys.servlet.diary;

import team.sdguys.entity.DiaryComment;
import team.sdguys.service.DiaryCommentService;
import team.sdguys.service.impl.DiaryCommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

/**
 * 添加日志评论
 */
@WebServlet("/addNewDiaryCommentServlet")
public class AddNewDiaryCommentServlet extends HttpServlet {

    DiaryCommentService diaryCommentService = new DiaryCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("uid");
        int did = Integer.parseInt(request.getParameter("did"));
        String dcContent = request.getParameter("dcContent");
        Date date = Date.valueOf(request.getParameter("date"));
        int dcLikeCount = Integer.parseInt(request.getParameter("dcLikeCount"));
        DiaryComment diaryComment = new DiaryComment(did,dcContent,uid, date,0);

        int result = diaryCommentService.insertnewDiaryComment(diaryComment);
        response.getWriter().write(result);


    }
}
