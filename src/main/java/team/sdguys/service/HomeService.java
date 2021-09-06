package team.sdguys.service;

import team.sdguys.entity.Book;
import team.sdguys.entity.Diary;
import team.sdguys.entity.Movie;

import java.util.List;

public interface HomeService {

    /**
     * @Description TODO 主页的电影推荐，显示六部电影
     * @return: 6部电影的信息
     * */
    List<Movie> getRecommendMovies();

    /**
     * @description TODO 主页的图书推荐，显示六本图书
     * @return: 六本图书的信息
     * */
    List<Book> getRecommendBooks();

    /**
     * @desceiption TODO 主页显示精选日志
     * @return: 按照时间排序的十个日志，如果继续下拉会刷新
     * */
    List<Diary> getRecommendDiaries();
}
