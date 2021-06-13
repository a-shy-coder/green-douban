package team.sdguys.servlet.user;

import team.sdguys.entity.Book;
import team.sdguys.entity.Movie;
import team.sdguys.service.BookCollectionService;
import team.sdguys.service.BookService;
import team.sdguys.service.MovieCollectionService;
import team.sdguys.service.MovieService;
import team.sdguys.service.impl.BookCollectionServiceImpl;
import team.sdguys.service.impl.BookServiceImpl;
import team.sdguys.service.impl.MovieCollectionServiceImpl;
import team.sdguys.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户收藏信息页面
 */
@WebServlet("/userCollectionInfoServlet")
public class UserCollectionInfoServlet extends HttpServlet {

    BookCollectionService bookCollectionService = new BookCollectionServiceImpl();
    MovieCollectionService movieCollectionService = new MovieCollectionServiceImpl();
    BookService bookService = new BookServiceImpl();
    MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int uid = (int) session.getAttribute("uid");
        List<Integer> bookIdList = bookCollectionService.findBookIdListByUid(uid);
        List<Book> bookCollectionList = new ArrayList<Book>();
        for(int bid:bookIdList) {
            bookCollectionList.add(bookService.findBookByBookId(bid));
        }
        List<Integer> movieIdList = movieCollectionService.findMovieIdListByUid(uid);
        List<Movie> movieCollectionList = new ArrayList<Movie>();
        for(int mid:movieIdList) {
            movieCollectionList.add(movieService.findMovieById(mid));
        }
        req.setAttribute("userBookCollectionList",bookCollectionList);
        req.setAttribute("userMovieCollectionList",movieCollectionList);

        req.getRequestDispatcher("jsp/user/userCollectionInfo.jsp").forward(req,resp);
    }
}
