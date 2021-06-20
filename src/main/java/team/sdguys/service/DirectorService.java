package team.sdguys.service;

import team.sdguys.entity.Director;

import java.util.List;

/**
 * 导演相关业务接口
 */
public interface DirectorService {
    /**
     * 通过导演编号找到导演
     * @param directorId 导演编号
     * @return 导演实体类
     */
    public Director findDirectorByDirectorId(int directorId);

    /**
     * 添加新电影导演
     * @param director 新导演
     * @return
     */
    public int addNewDirector(Director director);

    /**
     * 检索出所有的导演
     * @return
     */
    List<Director> getDirectorList();

    /**
     * 检索导员数量
     * @return
     */
    int getDirectorCount();

    /**
     * 分页查询导演
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Director> findDirectorByPage(int pageNo, int defaultPageSize);

    /**
     * 删除导演信息
     * @param directorId
     * @return
     */
    int deleteDirectorById(int directorId);

    /**
     * 添加导演
     * @param director
     * @return
     */
    int addDirector(Director director);

    /**
     * 修改导演信息
     * @param director
     * @return
     */
    int modifyDirectorById(Director director);
}
