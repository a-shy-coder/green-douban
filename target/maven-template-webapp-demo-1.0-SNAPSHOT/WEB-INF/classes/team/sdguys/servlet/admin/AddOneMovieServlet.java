package team.sdguys.servlet.admin;

import team.sdguys.entity.Movie;
import team.sdguys.service.impl.MovieManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/aoms")
public class AddOneMovieServlet extends HttpServlet {

    MovieManagerServiceImpl movieManagerServiceImpl=new MovieManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取新添加的图书的信息，封装成一个Movie对象
        req.setCharacterEncoding("utf-8");
        String MovieId = req.getParameter("MovieId");
        String MChineseName = req.getParameter("MChineseName");
        String MOriginName = req.getParameter("MOriginName");
        String MType = req.getParameter("MType");
        String MRating = req.getParameter("MRating");
        String MRatingCount = req.getParameter("MRatingCount");
        String MReleaseDate = req.getParameter("MReleaseDate");
        String DirectorId = req.getParameter("DirectorId");

        String mLanguage = req.getParameter("mLanguage");
        String mLength = req.getParameter("mLength");
        String mArea = req.getParameter("mArea");
        String mContent = req.getParameter("mContent");
        String mCover = req.getParameter("mCover");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        //获取图书的信息，封装成一个Book对象
        Movie movie=null;
        try {
            movie = new Movie(Integer.parseInt(MovieId) , MChineseName, MOriginName, MType,Float.parseFloat(MRating) ,Integer.parseInt(MRatingCount) , simpleDateFormat.parse(MReleaseDate) ,Integer.parseInt(DirectorId) ,mLanguage ,mLength ,mArea ,mContent, mCover);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //2. 执行业务逻辑
        //将新学生插入数据库
        int rows=movieManagerServiceImpl.addWholeMovie(movie);

        //3. 生成响应内容，这里直接返回了受影响的行数，用于判断是否插入成功
        resp.getWriter().println(rows);
    }
}