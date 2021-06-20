package team.sdguys.dao.impl;

import team.sdguys.dao.DiaryCommentDao;
import team.sdguys.entity.Diary;
import team.sdguys.entity.DiaryComment;
import team.sdguys.entity.DiaryComment;
import team.sdguys.entity.MovieComment;
import team.sdguys.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
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
                Diary diary = null;
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int autoIncrementId = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO sdguys.diarycomment (DId, DCcontent, UId, DCTime, DCLikeCount) VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,diaryComment.getDid());
            preparedStatement.setString(2,diaryComment.getdCContent());
            preparedStatement.setInt(3,diaryComment.getUid());
            preparedStatement.setObject(4, diaryComment.getdCTime());
            preparedStatement.setInt(5,diaryComment.getdCLikeCount());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                autoIncrementId = resultSet.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(null, preparedStatement, connection);
        }
        return autoIncrementId;
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

    @Override
    public List<DiaryComment> getDiaryCommentListByDiaryId(int diaryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DiaryComment> diaryCommentList = new ArrayList<DiaryComment>();
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from DiaryComment Where DId = ?");
            preparedStatement.setInt(1,diaryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DiaryComment diaryComment = new DiaryComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
                diaryCommentList.add(diaryComment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diaryCommentList;
    }

    @Override
    public void updateLikeCountByDiaryCommentId(int diaryCommentId, int i) {
        executeUpdate("UPDATE diarycomment SET DCLikeCount = DCLikeCount + ? WHERE DCId = ?",i,diaryCommentId);
    }

    @Override
    public DiaryComment getDiaryCommentByDiaryCommentId(int dcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DiaryComment diaryComment = null;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from DiaryComment Where DCId = ?");
            preparedStatement.setInt(1,dcId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                diaryComment = new DiaryComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diaryComment;
    }

    @Override
    public List<DiaryComment> getDiaryCommentListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DiaryComment> diaryCommentList = new ArrayList<DiaryComment>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from diaryComment Where UId = ?");
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DiaryComment diaryComment = new DiaryComment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getTimestamp(5),resultSet.getInt(6));
                diaryCommentList.add(diaryComment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diaryCommentList;
    }


}
