package team.sdguys.servlet.user;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import team.sdguys.util.CustomFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/uploadUserIconServlet")
public class UploadUserIconServlet extends HttpServlet {

    // 更改项目时, 需要改变此路径 !!!!
    // 暂时没有找到更好的解决方案
    private String saveDirectory = "D:\\WorkSpace\\IDEA\\sdguys1.1\\src\\main\\webapp\\img";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomFileRenamePolicy policy = new CustomFileRenamePolicy();
        MultipartRequest request
                = new MultipartRequest(req, saveDirectory, 100 * 1024 * 1024, "UTF-8", policy);

        String fileName = "img/" + request.getFile("file").getName();
        //上传的图片因为使用了文件重命名策略，所以上传的多个文件都会重命名的
        //为了在页面上显示上传的图片，需要将重命名的名称列表返回给页面
        //对于ajax请求，打印的响应内容就是返回的数据
        Gson gson = new Gson();
        String result = gson.toJson(fileName);
        System.out.println(fileName);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(result);
    }
}
