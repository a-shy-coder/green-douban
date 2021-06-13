package team.sdguys.servlet.diary;

import team.sdguys.service.DairyService;
import team.sdguys.service.impl.DiaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新日志的servlet
 */
@WebServlet("/updateDairyServlet")
public class UpdateDairyServlet {
    DairyService dairyService = new DiaryServiceImpl();

    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String content = request.getParameter("content");
        int did = Integer.parseInt(request.getParameter("did"));

        int result = dairyService.updateDiary(did, content);
        response.getWriter().write(result);


    }


}
