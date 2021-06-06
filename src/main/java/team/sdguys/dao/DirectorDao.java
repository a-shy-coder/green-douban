package team.sdguys.dao;

import team.sdguys.entity.Director;

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
}
