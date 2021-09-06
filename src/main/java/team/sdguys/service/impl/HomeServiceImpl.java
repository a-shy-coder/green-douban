package team.sdguys.service.impl;

import team.sdguys.dao.impl.BookDaoImpl;
import team.sdguys.dao.impl.DiaryDaoImpl;
import team.sdguys.dao.impl.MovieDaoImpl;
import team.sdguys.entity.Book;
import team.sdguys.entity.Diary;
import team.sdguys.entity.Movie;
import team.sdguys.service.HomeService;

import java.sql.SQLException;
import java.util.List;

public class HomeServiceImpl implements HomeService {

    MovieDaoImpl movieDao = new MovieDaoImpl();
    BookDaoImpl bookDao = new BookDaoImpl();
    DiaryDaoImpl diaryDao = new DiaryDaoImpl();

    @Override
    public List<Movie> getRecommendMovies() {
        try {
            return movieDao.getRecommandMovies();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getRecommendBooks() {
        try {
            return bookDao.getRecommandBooks();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Diary> getRecommendDiaries() {
        try {
            return diaryDao.getDiaryOrderByTimeDesc();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HomeServiceImpl homeService = new HomeServiceImpl();
        List<Movie> movieList = homeService.getRecommendMovies();
        for(Movie m : movieList){
            System.out.println(m.getMChineseName());
        }
    }
}
