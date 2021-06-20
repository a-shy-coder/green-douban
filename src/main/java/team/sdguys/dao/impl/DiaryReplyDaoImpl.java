package team.sdguys.dao.impl;

import team.sdguys.dao.DiaryReplyDao;
import team.sdguys.entity.BookReply;
import team.sdguys.entity.Diary;
import team.sdguys.entity.DiaryReply;
import team.sdguys.entity.MovieReply;
import team.sdguys.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiaryReplyDaoImpl extends BaseDaoImpl implements DiaryReplyDao {
    @Override
    public List<DiaryReply> getallbyDRId(List<Integer> dridlist) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DiaryReply> drlist = null;

        DiaryReply diaryReply = null;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from DiaryReply where DRId=?");
            for(int i = 0;i<dridlist.size();i++){
                preparedStatement.setInt(1, dridlist.get(i));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    diaryReply = new DiaryReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getDate(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                    drlist.add(diaryReply);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return drlist;     }

    @Override
    public int getDRFromIdbyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int DRFromId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRFromId from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DRFromId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DRFromId;    }

    @Override
    public int getDRToIdbyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int DRToId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRToId from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DRToId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DRToId;    }

    @Override
    public String getDRContentbyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String DRContent = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRCountent from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DRContent = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DRContent;    }

    @Override
    public Date getDRTimebyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Date DRTime = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRTime from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DRTime = resultSet.getTime(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DRTime;    }

    @Override
    public int getDIdbyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int DId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DId from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DId;    }

    @Override
    public int getDCIdbyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int DCId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DCId from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DCId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DCId;     }

    @Override
    public int getDRLikeCountbyDRId(int DRId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int DRLikeCount = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRLikeCount from DiaryReply where DRId=?");
            preparedStatement.setInt(1, DRId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DRLikeCount = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DRLikeCount;
    }

    @Override
    public List<Integer> getDRIdListbyDID(int DId) {
        return null;
    }

    @Override
    public List<Integer> getDRIdListbyDCId(List<Integer> list)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> dridlist = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRId from DiaryReply where DCId=?");
            for(int i = 0;i<list.size();i++){
                preparedStatement.setInt(1, list.get(i));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    dridlist.add(resultSet.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return dridlist;
    }

    @Override
    public List<Integer> getDRIdListbyDRFromId(int DRFromId) {
        return null;
    }

    @Override
    public List<Integer> getDRIdListbyDRToId(int DRToId) {
        return null;
    }

    @Override
    public List<Integer> getDRIdListbyDRLikeCount() {
        return null;
    }

    @Override
    public List<Integer> getDRIdListbyDRTime() {
        return null;
    }

    @Override
    public List<Integer> getTop5BRId() {
        return null;
    }

    @Override
    public int addoneDRLikeCount(int drid) {

        return executeUpdate("update DiaryReply set DRLikeCount = DRLikeCount+1 where DRId = ?",drid);
    }

    @Override
    public int suboneDRLikeCount(int drid) {
        return executeUpdate("update DiaryReply set DRLikeCount = DRLikeCount-1 where DRId = ?",drid);

    }

    @Override
    public int insertDiaryReply(DiaryReply diaryReply) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int autoIncrementId = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("insert into DiaryReply (DRFromId,DRToId,DRContent,DRTime,DId,DCId,DRLikeCount) value (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,diaryReply.getDRFromId());
            preparedStatement.setInt(2,diaryReply.getDRToId());
            preparedStatement.setString(3,diaryReply.getDRContent());
            preparedStatement.setObject(4, diaryReply.getDRTime());
            preparedStatement.setInt(5,diaryReply.getDId());
            preparedStatement.setInt(6,diaryReply.getDCId());
            preparedStatement.setInt(7,diaryReply.getDRLikeCount());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                autoIncrementId = resultSet.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return autoIncrementId;
    }

    @Override
    public int deleteDiaryReply(int Drid,int uid) {
        return executeUpdate("delete from DiaryReply where DRId = ? and UId = ?",Drid,uid);
    }

    @Override
    public List<Integer> getDridListbyuid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> dridlist = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DRId from DiaryReply where UId=?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dridlist.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return dridlist;    }

    @Override
    public void updateLikeCountByDiaryReplyId(int diaryReplyId, int i) {
        executeUpdate("UPDATE diaryreply SET DRLikeCount = DRLikeCount + ? WHERE DRId = ?",i,diaryReplyId);
    }

    @Override
    public List<DiaryReply> getDiaryReplyListByDiaryCommentId(int dcId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DiaryReply> diaryReplyList = new ArrayList<DiaryReply>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM diaryReply WHERE DCId = ?");
            preparedStatement.setInt(1,dcId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DiaryReply diaryReply = new DiaryReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                diaryReplyList.add(diaryReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diaryReplyList;
    }

    @Override
    public List<DiaryReply> getDiaryReplyListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DiaryReply> diaryReplyList = new ArrayList<DiaryReply>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM diaryReply WHERE DRFromId = ?");
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DiaryReply diaryReply = new DiaryReply(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8));
                diaryReplyList.add(diaryReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diaryReplyList;
    }

    @Override
    public int deleteDiaryReplyByDiaryReplyId(int diaryReplyId) {
        return executeUpdate("DELETE FROM diaryReply WHERE DRId = ?",diaryReplyId);
    }
}
