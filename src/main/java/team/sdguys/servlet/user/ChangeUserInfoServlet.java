package team.sdguys.servlet.user;

import team.sdguys.entity.UserInfo;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 修改个人信息的Servlet
 */
@WebServlet("/changeInfoServlet")
public class ChangeUserInfoServlet extends HttpServlet {
    UserInfoService userInfoService = new UserInfoServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        int uid = (int) session.getAttribute("uid");
        String Uicon = request.getParameter("Uicon");
        String Ugender = request.getParameter("Uaddress");
        String Uaddress = request.getParameter("Uaddress");
        Date Ubirthday = null;
        try {
            Ubirthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String Usign = request.getParameter("Usign");

        UserInfo userInfo = new UserInfo(uid,Uicon,Ugender,Uaddress,Ubirthday,Usign);
        int result = userInfoService.resetUserInfo(userInfo);
        response.getWriter().write(result);
    }
}
