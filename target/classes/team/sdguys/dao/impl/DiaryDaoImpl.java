package team.sdguys.dao.impl;

import team.sdguys.dao.DiaryDao;
import team.sdguys.entity.Diary;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                diary = new Diary(resultSet.getInt(1), resultSet.getString(2),resultSet.getTime(3),resultSet.getInt(4),resultSet.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diary;    }

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
        return executeUpdate("insert into Diary (DiaryContent,DiaryTime,UId,DLikeCount) value (?,?,?,0)",diary.getDiaryContent(),diary.getDiaryTime(),diary.getUId());
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
}
