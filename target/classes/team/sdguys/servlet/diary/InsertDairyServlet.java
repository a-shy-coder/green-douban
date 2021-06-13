package team.sdguys.servlet.diary;

import team.sdguys.entity.Diary;
import team.sdguys.service.DairyService;
import team.sdguys.service.impl.DiaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 新建一个日志的servlet
 */
@WebServlet("/insertDairyServlet")
public class InsertDairyServlet extends HttpServlet{

    DairyService dairyService = new DiaryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String content = request.getParameter("content");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        HttpSession session = request.getSession();
        int uid  = (int) session.getAttribute("uid");

        Diary diary = new Diary(content,timestamp,uid,0);
        int result = dairyService.insertNewDiary(diary);

        response.getWriter().write(result);

    }
}
