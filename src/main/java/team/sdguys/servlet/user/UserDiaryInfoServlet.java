package team.sdguys.servlet.user;

import team.sdguys.entity.Book;
import team.sdguys.entity.Diary;
import team.sdguys.entity.Movie;
import team.sdguys.service.*;
import team.sdguys.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户日志信息页面
 */
@WebServlet("/userDiaryInfoServlet")
public class UserDiaryInfoServlet extends HttpServlet {

    DiaryService diaryService = new DiaryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<Diary> userDiaryList = diaryService.getDiaryListByUid(uid);
        req.setAttribute("userDiaryList",userDiaryList);

        req.getRequestDispatcher("jsp/user/userDiaryInfo.jsp").forward(req,resp);
    }
}
