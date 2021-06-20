package team.sdguys.dao.impl;

import team.sdguys.dao.DiaryDao;
import team.sdguys.entity.Diary;
import team.sdguys.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiaryDaoImpl extends BaseDaoImpl implements DiaryDao {
    @Override
    public Diary getallbyDiaryId(int DiaryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Diary diary = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Diary where DiaryId=?");
            preparedStatement.setInt(1, DiaryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                diary = new Diary(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getTimestamp(4),resultSet.getInt(5),resultSet.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diary;
    }

    @Override
    public String getDiaryContentbyDiaryId(int DiaryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String DiaryContent = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryContent from Diary where DiaryId=?");
            preparedStatement.setInt(1, DiaryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DiaryContent = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DiaryContent;    }

    @Override
    public Date getDiaryTimebyDiaryId(int DiaryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Date DiaryTime = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryTime from Diary where DiaryId=?");
            preparedStatement.setInt(1, DiaryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DiaryTime = resultSet.getTime(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DiaryTime;     }

    @Override
    public int getUIdbyDiaryId(int DiaryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int UId = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select UId from Diary where DiaryId=?");
            preparedStatement.setInt(1, DiaryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return UId;    }

    @Override
    public int getDLikeCountbyDiaryId(int DiaryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int DLikeCount = 0;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DLikeCount from Diary where DiaryId=?");
            preparedStatement.setInt(1, DiaryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DLikeCount = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return DLikeCount;    }

    @Override
    public List<Integer> getownDiaryIdbyUId(int UId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryId from Diary where UId = ?");
            preparedStatement.setInt(1, UId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public int insertNewDiary(Diary diary) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int autoIncrementId = 0;
        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO diary (DiaryContent, DiaryTime, UId, DLikeCount, DiaryTitle) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,diary.getDiaryContent());
            preparedStatement.setObject(2,diary.getDiaryTime());
            preparedStatement.setInt(3,diary.getUId());
            preparedStatement.setInt(4,diary.getDLikeCount());
            preparedStatement.setString(5,diary.getDiaryTitle());
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
    public int updateDiary(int DiaryId,String DiaryContent) {
        return executeUpdate("update Diary set DiaryContent = ? where DiaryId = ?",DiaryContent,DiaryId);
    }

    @Override
    public int deleteDiary(int DiaryId) {
        return executeUpdate("delete from Diary where DiaryId = ?",DiaryId);
    }

    @Override
    public int addoneDLikeCount(Diary diary) {
        return executeUpdate("update Diary set DLikeCount = DLikeCount+1 where DiaryId = ?",diary.getDiaryId());
    }

    @Override
    public int suboneDLikeCount(Diary diary) {
        return executeUpdate("update Diary set DLikeCount = DLikeCount-1 where DiaryId = ?",diary.getDiaryId());
    }

    @Override
    public List<Integer> getDiaryIdListByDlikeCount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryId from Diary order by DLikeCount desc ");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public List<Integer> getDiaryIdListByDiaryTime() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryId from Diary order by DiaryTime desc");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public List<Integer> getTop5DiaryId() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryId from Diary order by DLikeCount desc limit 5");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public List<Diary> getDiaryListByUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Diary> diaryList = new ArrayList<Diary>();

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Diary where uid=?");
            preparedStatement.setInt(1, uid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Diary diary = new Diary(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getTimestamp(4),resultSet.getInt(5),resultSet.getInt(6));
                diaryList.add(diary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diaryList;
    }
}
