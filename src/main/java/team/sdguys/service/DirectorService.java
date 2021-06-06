package team.sdguys.service;

import team.sdguys.entity.Director;

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
}
