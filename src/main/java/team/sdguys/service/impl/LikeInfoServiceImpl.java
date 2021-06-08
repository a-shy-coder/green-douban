package team.sdguys.service.impl;

import team.sdguys.dao.LikeInfoDao;
import team.sdguys.dao.impl.LikeInfoDaoImpl;
import team.sdguys.entity.LikeInfo;
import team.sdguys.service.LikeInfoService;

import java.util.List;

/**
 * 点赞业务逻辑接口的实现类
 */
public class LikeInfoServiceImpl implements LikeInfoService {

    LikeInfoDao likeInfoDao = new LikeInfoDaoImpl();

    @Override
    public void insertLikeInfo(LikeInfo likeInfo) {
        likeInfoDao.insertLikeInfo(likeInfo);
    }

    @Override
    public void deleteLikeInfoByUidAndLikeIdAndType(int uid, int likeId, int type) {
        likeInfoDao.deleteLikeInfoByUidAndLikeIdAndType(uid,likeId,type);
    }

    @Override
    public List<Integer> findLikeIdListByUidAndType(int uid, int type) {
        return likeInfoDao.findLikeIdListByUidAndType(uid,type);
    }
}
