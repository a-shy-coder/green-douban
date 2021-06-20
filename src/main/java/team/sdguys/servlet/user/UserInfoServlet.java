package team.sdguys.servlet.user;

import team.sdguys.entity.User;
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

/**
 * 我的信息页面
 */
@WebServlet("/userInfoServlet")
public class UserInfoServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(false);
        int uid = (int) httpSession.getAttribute("uid");

        User user = userService.findUserByUid(uid);
        req.setAttribute("user",user);

        UserInfo userInfo  =  userInfoService.findUserInfoById(uid);
        req.setAttribute("userInfo",userInfo);

        String address = userInfo.getUaddress();
        String province = null;
        String city = null;
        String area = null;

        if(null != address){
            province = address.substring(0,address.indexOf('省') + 1);
            city = address.substring(address.indexOf('省') + 1,address.indexOf('市') + 1);
            area = address.substring(address.indexOf('市') + 1);
        }

        req.setAttribute("province",province);
        req.setAttribute("city",city);
        req.setAttribute("area",area);

        req.getRequestDispatcher("jsp/user/userInfo.jsp").forward(req, resp);
    }
}
