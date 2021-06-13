package team.sdguys.servlet.admin;

import team.sdguys.entity.Author;
import team.sdguys.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddOneAuthorServlet extends HttpServlet {

    AuthorService authorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取新添加的图书作者的信息，封装成一个Author对象

        String AuthorId = req.getParameter("AuthorId");
        String AuthorChineseName = req.getParameter("AuthorChineseName");
        String AuthorOriginName = req.getParameter("AuthorOriginName");
        String AuthorInfo = req.getParameter("AuthorInfo");
        String AuthorGender = req.getParameter("AuthorGender");
        String AuthorImg = req.getParameter("AuthorImg");


        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        //获取图书的信息，封装成一个Book对象
        Author author= new Author(Integer.parseInt(AuthorId) , AuthorChineseName, AuthorOriginName, AuthorInfo , AuthorGender ,AuthorImg );

        //2. 执行业务逻辑
        //将新图书插入数据库
        int rows=authorService.addNewAuthor(author);

        //3. 生成响应内容，这里直接返回了受影响的行数，用于判断是否插入成功
        resp.getWriter().println(rows);
    }
}
