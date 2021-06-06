package team.sdguys.service.impl;

import team.sdguys.dao.DiaryDao;
import team.sdguys.dao.impl.DiaryImpl;
import team.sdguys.entity.Diary;
import team.sdguys.service.DairyService;
import team.sdguys.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DiaryServiceImpl implements DairyService {
    DiaryDao diaryDao = new DiaryImpl();
    @Override
    public int insertNewDiary(Diary diary) {
        return diaryDao.executeUpdate("insert into Diary (DiaryContent,DiaryTime,UId,DLikeCount) value (?,?,?,0)",diary.getDiaryContent(),diary.getDiaryTime(),diary.getUId());

    }

    @Override
    public int updateDiary(int DiaryId,String DiaryContent) {
        return diaryDao.executeUpdate("update Diary set DiaryContent = ? where DiaryId = ?",DiaryContent,DiaryId);
    }

    @Override
    public int deleteDiary(int DiaryId) {
        return diaryDao.executeUpdate("delete from Diary where DiaryId = ?",DiaryId);
    }

    @Override
    public int addoneDLikeCount(int DiaryId) {
        return diaryDao.executeUpdate("update Diary set DLikeCount = DLikeCount+1 where DiaryId = ?",DiaryId);
    }

    @Override
    public int suboneDLikeCount(int DiaryId) {
        return diaryDao.executeUpdate("update Diary set DLikeCount = DLikeCount-1 where DiaryId = ?",DiaryId);
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
    public List<Integer> getDiaryIdListByDiaryTime(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryId from Diary where UId = ? order by DiaryTime desc");
            preparedStatement.setInt(1,uid);
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
    public List<Integer> getTop5DiaryId(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> list = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select DiaryId from Diary where UId = ? order by DLikeCount desc limit 5");
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                list.add((resultSet.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return list;    }

    @Override
    public List<Diary> getdiarybylist(List<Integer> list) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Diary> diarylist = null;

        try {
            connection = DataBaseUtil.getConnection();
            preparedStatement = connection.prepareStatement("select * from Diary where MId=?");
            for(int i = 0;i<list.size();i++){
                Diary diary = null;
                preparedStatement.setInt(1, list.get(i));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    diary = new Diary(resultSet.getInt(1), resultSet.getString(2),resultSet.getTime(3),resultSet.getInt(4),resultSet.getInt(5));
                    diarylist.add(diary);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(resultSet, preparedStatement, connection);
        }
        return diarylist;    }

    @Override
    public Diary getallbyDiaryId(int did) {
        return diaryDao.getallbyDiaryId(did);
    }
}
