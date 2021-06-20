package team.sdguys.servlet.diary;

import team.sdguys.service.DiaryService;
import team.sdguys.service.MovieCollectionService;
import team.sdguys.service.impl.DiaryServiceImpl;
import team.sdguys.service.impl.MovieCollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除日志的Servlet
 */
@WebServlet("/deleteDiaryServlet")
public class DeleteDiaryServlet extends HttpServlet {

    DiaryService diaryService = new DiaryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int diaryId = Integer.parseInt(req.getParameter("diaryId"));
        int rows = diaryService.deleteDiary(diaryId);
        resp.getWriter().write(rows);
    }
}
