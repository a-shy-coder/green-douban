package team.sdguys.dao.impl;

import team.sdguys.dao.DiaryCommentDao;
import team.sdguys.entity.Book;
import team.sdguys.entity.DiaryComment;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DiaryCommentDaoImpl extends BaseDaoImpl implements DiaryCommentDao {
    @Override
    public List<Integer> getdcidlistbydid(int did) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> dcidlist = null;


        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DCId from DiaryComment where DId=?");
            preparedStatement.setInt(1, did);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dcidlist.add((resultSet.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return dcidlist;    }

    @Override
    public List<DiaryComment> getDClistbydcidlist(List<Integer> list) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;
        DiaryComment diaryComment = null;
        List<DiaryComment> dclist = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from DiaryComment where DCId=?");
            for(int i = 0;i<list.size();i++){
                Book book = null;
                preparedStatement.setInt(1, list.get(i));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    diaryComment = new DiaryComment(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDate(5),resultSet.getInt(6));
                    dclist.add(diaryComment);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return dclist;     }

    @Override
    public List<Integer> getdcidbyuid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> dcidlist = null;


        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DCId from DiaryComment where UId=?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dcidlist.add((resultSet.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return dcidlist;     }

    @Override
    public int InsertDiaryComment(DiaryComment diaryComment) {
        return executeUpdate("insert into DiaryComment (DId,DCcontent,UId,DCTime,DCLikeCount) value (?,?,?,?,0)",diaryComment.getDid(),diaryComment.getdCContent(),diaryComment.getUid(),diaryComment.getdCTime());
    }

    @Override
    public int updateDiaryComment(String dcContent, int uid,int dcid) {
        return executeUpdate("update DiaryComment set DCcontent = ? where DCId = ? and UId = ?",dcContent,dcid,uid);
    }

    @Override
    public int deleteDiaryComment(int dcid,int uid) {
        return executeUpdate("delete from DiaryComment where DCId = ? and UId = ?",dcid,uid);
    }

    @Override
    public int addoneDCLikeCount(int DCId) {
        return executeUpdate("update DiaryComment set DCLikeCount = DClikeCount+1 where DCId = ?",DCId);
    }

    @Override
    public int suboneDCLikeCount(int DCId) {
        return executeUpdate("update DiaryComment set DCLikeCount = DCLikeCount-1 where DCId = ?",DCId);
    }


}
