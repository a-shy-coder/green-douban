package team.sdguys.service;

import team.sdguys.entity.*;

import java.util.List;

public interface SearchService {

    /**
     * @description TODO 模糊查询电影
     * */
    List<Movie> getMovieByLikeName(String name);

    /**
     * @description TODO 模糊查询图书
     * */
    List<Book> getBookByLikeName(String name);

    /**
     * @description TODO 模糊查询导演
     * */
    List<Director> getDirectorByLikeName(String name);

    /**
     * @description TODO 模糊查询演员
     * */
    List<Actor> getActorByLikeName(String name);

    /**
     * @description TODO 模糊查询作者
     * */
    List<Author> getAuthorByLikeName(String name);

}
