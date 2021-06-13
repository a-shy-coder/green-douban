package team.sdguys.servlet.user;

import team.sdguys.entity.UserInfo;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.UserService;
import team.sdguys.service.impl.UserInfoServiceImpl;
import team.sdguys.service.impl.UserServiceImpl;

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
@WebServlet("/modifyUserInfoServlet")
public class ModifyUserInfoServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(false);
        int uid = (int) httpSession.getAttribute("uid");
        String nickyName = req.getParameter("nickyName");
        String iconImg = req.getParameter("iconImg");
        String address = req.getParameter("province") + req.getParameter("city") + req.getParameter("area");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String gender = req.getParameter("gender");
        String sign = req.getParameter("sign");

        userService.resetUserName(nickyName,uid);
        UserInfo userInfo = userInfoService.findUserInfoById(uid);
        userInfo.setUaddress(address);
        userInfo.setUbirthday(birthday);
        userInfo.setUgender(gender);
        userInfo.setUicon(iconImg);
        userInfo.setUsign(sign);
        userInfoService.modifyUserInfo(userInfo);
    }
}
