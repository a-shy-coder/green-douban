package team.sdguys.service.impl;

import team.sdguys.dao.impl.*;
import team.sdguys.entity.*;
import team.sdguys.service.SearchService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    MovieDaoImpl movieDao = new MovieDaoImpl();
    BookDaoImpl bookDao = new BookDaoImpl();
    ActorDaoImpl actorDao = new ActorDaoImpl();
    AuthorDaoImpl authorDao = new AuthorDaoImpl();
    DirectorDaoImpl directorDao = new DirectorDaoImpl();

    @Override
    public List<Movie> getMovieByLikeName(String name) {
        try {
            return movieDao.getMovieByLikeName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookByLikeName(String name) {
        try {
            return bookDao.getBookByLikeName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Director> getDirectorByLikeName(String name) {
        try {
            return directorDao.getDirectorByLikeName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Actor> getActorByLikeName(String name) {
        try {
            return actorDao.getActorByLikeName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> getAuthorByLikeName(String name) {
        try {
            return authorDao.getAuthorByLikeName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SearchServiceImpl searchService = new SearchServiceImpl();
        List<Movie> movieList = new ArrayList<>();
        movieList = searchService.getMovieByLikeName("小");
        for (Movie m : movieList) {
            System.out.println(m.getMChineseName());
        }
    }
}
