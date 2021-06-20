package team.sdguys.servlet.diary;

import team.sdguys.service.DiaryService;
import team.sdguys.service.impl.DiaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除日记的servlet
 */
@WebServlet("/deleteDairySerlvet")
public class DeleteDairySerlvet extends HttpServlet{

    DiaryService dairyService = new DiaryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        int did = Integer.parseInt(request.getParameter("did"));

        int result = dairyService.deleteDiary(did);
        response.getWriter().write(result);



    }
}
