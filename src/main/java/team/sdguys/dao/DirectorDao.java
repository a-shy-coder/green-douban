package team.sdguys.dao;

import team.sdguys.entity.Director;

import java.util.List;

/**
 * 电影表的接口
 */
public interface DirectorDao extends BaseDao{
    /**
     * 通过导演编号找道导演
     * @param DirectorId 导演编号
     * @return 导演
     */
    public Director getDirectorByDirectorId(int DirectorId);

    /**
     * 检索出所有的导演
     * @return
     */
    List<Director> getDirectorList();

    /**
     * 分页查询所有导演
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Director> getDirectorByPage(int pageNo, int defaultPageSize);

    /**
     * 检索导演数量
     * @return
     */
    int getDirectorCount();

    /**
     * 删除导演信息
     * @param directorId
     * @return
     */
    int deleteDirectorById(int directorId);

    /**
     * 添加导演信息
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
