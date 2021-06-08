package team.sdguys.dao.impl;

import team.sdguys.dao.LikeInfoDao;
import team.sdguys.entity.LikeInfo;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * LikeInfo表的Dao层的实现类
 */
public class LikeInfoDaoImpl extends BaseDaoImpl implements LikeInfoDao {
    @Override
    public int insertLikeInfo(LikeInfo likeInfo) {
        return executeUpdate("INSERT INTO likeInfo (uid, likeId, type) VALUES (?, ?, ?)",likeInfo.getuId(),likeInfo.getLikeId(),likeInfo.getType());
    }

    @Override
    public int deleteLikeInfoByUidAndLikeIdAndType(int uid, int likeId, int type) {
        return executeUpdate("DELETE FROM sdguys.likeinfo WHERE uid = ? AND likeId = ? AND type = ?",uid,likeId,type);
    }

    @Override
    public List<Integer> findLikeIdListByUidAndType(int uid, int type) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();

        try{
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT likeId FROM likeinfo WHERE uid = ? AND type = ?");
            preparedStatement.setInt(1, uid);
            preparedStatement.setInt(2, type);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add((resultSet.getInt(1)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(resultSet,preparedStatement,connection);
        }
        return list;
    }
}
