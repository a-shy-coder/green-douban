package team.sdguys.service;

import team.sdguys.entity.Movie;

public interface MovieManagerService {

    /**
     * 添加新电影
     * @param movie 新电影
     */
    public int addWholeMovie(Movie movie);

    /**
     * 根据id删除电影
     * @param mid 电影id
     * @return true 正确 false 不正确
     */
    public int deleteMovieById(int mid);

}
