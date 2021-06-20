package team.sdguys.servlet.diary;

import team.sdguys.entity.Diary;
import team.sdguys.entity.DiaryComment;
import team.sdguys.entity.User;
import team.sdguys.entity.UserInfo;
import team.sdguys.service.DiaryCommentService;
import team.sdguys.service.DiaryService;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.UserService;
import team.sdguys.service.impl.DiaryCommentServiceImpl;
import team.sdguys.service.impl.DiaryServiceImpl;
import team.sdguys.service.impl.UserInfoServiceImpl;
import team.sdguys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 日志详情页
 */
@WebServlet("/diaryInfoServlet")
public class DiaryInfoServlet extends HttpServlet {

    DiaryService diaryService = new DiaryServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();
    UserService userService = new UserServiceImpl();
    DiaryCommentService diaryCommentService = new DiaryCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int diaryId = Integer.parseInt(req.getParameter("diaryId"));

        // 日志的相关信息 及 日志的发表用户的先关信息
        Diary diary = diaryService.getallbyDiaryId(diaryId);
        UserInfo userInfo = userInfoService.findUserInfoById(diary.getUId());
        User user = userService.findUserByUid(diary.getUId());
        req.setAttribute("diaryUserInfo",userInfo);
        req.setAttribute("diaryUser",user);
        req.setAttribute("diary",diary);

        //日志的评论信息
        List<DiaryComment> diaryCommentList = diaryCommentService.getDiaryCommentListByDiaryId(diaryId);
        req.setAttribute("diaryCommentList",diaryCommentList);

        req.getRequestDispatcher( "jsp/diary/diaryInfo.jsp").forward(req,resp);

    }
}
