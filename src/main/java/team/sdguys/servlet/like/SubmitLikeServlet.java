package team.sdguys.servlet.like;

import team.sdguys.entity.LikeInfo;
import team.sdguys.service.*;
import team.sdguys.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 点赞的Servlet
 */
@WebServlet("/submitLikeServlet")
public class SubmitLikeServlet extends HttpServlet {

    LikeInfoService likeInfoService = new LikeInfoServiceImpl();
    MovieCommentService movieCommentService = new MovieCommentServiceImpl();
    MovieReplyService movieReplyService = new MovieReplyServiceImpl();
    BookCommentService bookCommentService = new BookCommentServiceImpl();
    BookReplyService bookReplyService = new BookReplyServiceImpl();
    DiaryCommentService diaryCommentService = new DiaryCommentServiceImpl();
    DiaryReplyService diaryReplyService = new DiaryReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        int type = Integer.parseInt(req.getParameter("type"));
        int likeId = Integer.parseInt(req.getParameter("likeId"));
        int count = Integer.parseInt(req.getParameter("count"));
        // 需要判断点赞还是取消赞
        if(count == 1){
            likeInfoService.insertLikeInfo(new LikeInfo(uid,likeId,type));
            // 需要判断点赞的是哪一种
            if(type == 0){
                movieCommentService.updateLikeCountByMovieCommentId(likeId,1);
            }else if(type == 1){
                movieReplyService.updateLikeCountByMovieReplyId(likeId,1);
            }else if(type == 2){
                bookCommentService.updateLikeCountByBookCommentId(likeId,1);
            }else if(type == 3){
                bookReplyService.updateLikeCountByBookReplyId(likeId,1);
            }else if(type == 4){
                diaryCommentService.updateLikeCountByDiaryCommentId(likeId,1);
            }else{
                diaryReplyService.updateLikeCountByDiaryReplyId(likeId,1);
            }
        }else{
            likeInfoService.deleteLikeInfoByUidAndLikeIdAndType(uid,likeId,type);
            // 需要判断取消点赞的是哪一种
            if(type == 0){
                movieCommentService.updateLikeCountByMovieCommentId(likeId,-1);
            }else if(type == 1){
                movieReplyService.updateLikeCountByMovieReplyId(likeId,-1);
            }else if(type == 2){
                bookCommentService.updateLikeCountByBookCommentId(likeId,-1);
            }else if(type == 3){
                bookReplyService.updateLikeCountByBookReplyId(likeId,-1);
            }else if(type == 4){
                diaryCommentService.updateLikeCountByDiaryCommentId(likeId,-1);
            }else{
                diaryReplyService.updateLikeCountByDiaryReplyId(likeId,-1);
            }
        }
    }
}
