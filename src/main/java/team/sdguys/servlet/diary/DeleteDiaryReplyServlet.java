package team.sdguys.servlet.diary;

import team.sdguys.service.DiaryReplyService;
import team.sdguys.service.impl.DiaryReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteDiaryReplyServlet")
public class DeleteDiaryReplyServlet extends HttpServlet {

    DiaryReplyService diaryReplyService = new DiaryReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  diaryReplyId = Integer.parseInt(req.getParameter("diaryReplyId"));
        int rows = diaryReplyService.deleteDiaryReplyByDiaryReplyId(diaryReplyId);
    }
}
