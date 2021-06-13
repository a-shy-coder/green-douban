package team.sdguys.servlet.admin;

import team.sdguys.entity.Book;
import team.sdguys.service.impl.BookManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/aobs")
public class AddOneBookServlet extends HttpServlet {

    BookManagerServiceImpl bookManagerService=new BookManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取新添加的图书的信息，封装成一个Book对象
        req.setCharacterEncoding("utf-8");
        String BId = req.getParameter("BId");
        String BChineseName = req.getParameter("BChineseName");
        String BOriginName = req.getParameter("BOriginName");
        String BType = req.getParameter("BType");
        String BRating = req.getParameter("BRating");
        String BRatingCount = req.getParameter("BRatingCount");
        String BReleaseDate = req.getParameter("BReleaseDate");
        String BPublisher = req.getParameter("BPublisher");
        String AuthorId = req.getParameter("AuthorId");

        String BPageCount = req.getParameter("BPageCount");
        String BBinding = req.getParameter("BBinding");
        String BContent = req.getParameter("BContent");
        String BLanguage = req.getParameter("BLanguage");
        String BCover = req.getParameter("BCover");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        //获取图书的信息，封装成一个Book对象
        Book book=null;
        try {
            book = new Book(Integer.parseInt(BId) , BChineseName, BOriginName, BType,Float.parseFloat(BRating) ,Integer.parseInt(BRatingCount) , simpleDateFormat.parse(BReleaseDate) , BPublisher,Integer.parseInt(AuthorId) , Integer.parseInt(BPageCount), BBinding,BContent , BLanguage, BCover);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //2. 执行业务逻辑
        //将新图书插入数据库
        int rows=bookManagerService.addWholeBook(book);

        //3. 生成响应内容，这里直接返回了受影响的行数，用于判断是否插入成功
        resp.getWriter().println(rows);
    }
}