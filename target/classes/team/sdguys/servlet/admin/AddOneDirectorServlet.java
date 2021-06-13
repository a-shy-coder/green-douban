package team.sdguys.servlet.admin;

import team.sdguys.entity.Director;
import team.sdguys.service.DirectorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddOneDirectorServlet extends HttpServlet {

    DirectorService directorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取新添加的图书作者的信息，封装成一个Author对象

        String directorId = req.getParameter("directorId");
        String directorChineseName = req.getParameter("directorChineseName");
        String directorOriginName = req.getParameter("directorOriginName");
        String directorInfo = req.getParameter("directorInfo");
        String directorGender = req.getParameter("directorGender");
        String directorImg = req.getParameter("directorImg");


        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        //获取图书的信息，封装成一个Book对象
        Director director= new Director(Integer.parseInt(directorId) , directorChineseName, directorOriginName, directorInfo , directorGender ,directorImg );

        //2. 执行业务逻辑
        //将新图书插入数据库
        int rows=directorService.addNewDirector(director);

        //3. 生成响应内容，这里直接返回了受影响的行数，用于判断是否插入成功
        resp.getWriter().println(rows);
    }
}
