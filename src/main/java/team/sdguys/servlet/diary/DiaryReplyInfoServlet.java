package team.sdguys.servlet.diary;

import team.sdguys.entity.DiaryComment;
import team.sdguys.entity.DiaryReply;
import team.sdguys.service.DiaryCommentService;
import team.sdguys.service.DiaryReplyService;
import team.sdguys.service.impl.DiaryCommentServiceImpl;
import team.sdguys.service.impl.DiaryReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 日志回复页面的Servlet
 */
@WebServlet("/diaryReplyInfoServlet")
public class DiaryReplyInfoServlet extends HttpServlet {

    DiaryReplyService diaryReplyService = new DiaryReplyServiceImpl();
    DiaryCommentService diaryCommentService = new DiaryCommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 评论编号
        int dcId = Integer.parseInt(req.getParameter("diaryCommentId"));

        // 查找这条评论
        DiaryComment diaryComment = diaryCommentService.findDiaryCommentByDiaryCommentId(dcId);
        req.setAttribute("diaryComment",diaryComment);

        // 查找评论的所有回复
        List<DiaryReply> diaryReplyList = diaryReplyService.getDiaryReplyListByDiaryCommentId(dcId);
        req.setAttribute("diaryReplyList",diaryReplyList);

        req.getRequestDispatcher("jsp/diary/diaryReplyInfo.jsp").forward(req, resp);
    }
}
