package team.sdguys.servlet.diary;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import team.sdguys.entity.Image;
import team.sdguys.entity.Result;
import team.sdguys.util.CustomMultiFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/uploadDiaryImageServlet")
public class UploadDiaryImageServlet extends HttpServlet {

    private String saveDirectory = "D:\\WorkSpace\\IDEA\\sdguys1.2\\src\\main\\webapp\\img\\diaryImg";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomMultiFileRenamePolicy policy = new CustomMultiFileRenamePolicy();

        MultipartRequest mreq = new MultipartRequest(req, saveDirectory, 100 * 1024 * 1024, "utf-8", policy);

        List<String> fileNameList = policy.getFileNames();
        //创建一个List<Image>列表，将上传的图片信息封装到该列表中
        List<Image> imageList=new ArrayList<>();

        for (String name : fileNameList) {
            Image img=new Image("/diaryImg/"+name);
            imageList.add(img);
        }

        //指定一个错误代码(0表示没有错误)和一个图片列表，封装一个Result对象
        Result result=new Result(0,imageList);

        Gson gson=new Gson();
        String data=gson.toJson(result);
        resp.setContentType("application/json;charset=utf-8");
        //将转成的json数据作为数据返回
        resp.getWriter().println(data);
    }
}
