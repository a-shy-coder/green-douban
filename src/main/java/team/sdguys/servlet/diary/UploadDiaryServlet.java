package team.sdguys.servlet.diary;

import team.sdguys.entity.Diary;
import team.sdguys.service.DiaryService;
import team.sdguys.service.impl.DiaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * 上传日志的Servlet
 */
@WebServlet("/uploadDiaryServlet")
public class UploadDiaryServlet extends HttpServlet {

    DiaryService diaryService = new DiaryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 日志标题
        String title = req.getParameter("diaryTitle");
        // 日志内容
        String content = req.getParameter("diaryContent");
        // 日志发布时间
        Date date = new Date();
        // 日志发布用户编号
        HttpSession httpSession = req.getSession(false);
        int uid = (int) httpSession.getAttribute("uid");
        Diary diary = new Diary(title,content,date,uid,0);

        // 将日志插入数据库
        int diaryId = diaryService.insertNewDiary(diary);
        System.out.println(diaryId);
        resp.getWriter().print(diaryId);
    }
}
