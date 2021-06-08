package team.sdguys.servlet.like;

import com.google.gson.Gson;
import team.sdguys.service.LikeInfoService;
import team.sdguys.service.impl.LikeInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkLikeServlet")
public class CheckLikeServlet extends HttpServlet {

    LikeInfoService likeInfoService = new LikeInfoServiceImpl();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        int type = Integer.parseInt(req.getParameter("type"));
        List<Integer> likeIdList = likeInfoService.findLikeIdListByUidAndType(uid, type);
        String likeIdListGson = gson.toJson(likeIdList);
        resp.getWriter().write(likeIdListGson);
    }
}
