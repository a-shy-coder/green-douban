package team.sdguys.service.impl;

import team.sdguys.dao.DiaryReplyDao;
import team.sdguys.dao.impl.DiaryReplyDaoImpl;
import team.sdguys.entity.DiaryReply;
import team.sdguys.service.DiaryReplyService;

import java.util.List;

public class DiaryReplyServiceImpl implements DiaryReplyService {
    DiaryReplyDao diaryReplyDao = new DiaryReplyDaoImpl();
    @Override
    public List<Integer> getDridlistbyDCId(List<Integer> list) {
        return diaryReplyDao.getDRIdListbyDCId(list);
    }

    @Override
    public List<DiaryReply> getDiaryReplybydrid(List<Integer> dridlist) {
        return diaryReplyDao.getallbyDRId(dridlist);
    }

    @Override
    public List<Integer> getDridListbyuid(int uid) {
        return diaryReplyDao.getDridListbyuid(uid);
    }

    @Override
    public int addoneDrLikeCount(int drid) {
        return diaryReplyDao.addoneDRLikeCount(drid);
    }

    @Override
    public int deleteoneDrLikeCount(int drid) {
        return diaryReplyDao.suboneDRLikeCount(drid);
    }

    @Override
    public int addoneDiaryReply(DiaryReply diaryReply) {
        return diaryReplyDao.insertDiaryReply(diaryReply);
    }

    @Override
    public int deleteoneDiaryReply(int Drid, int uid) {
        return diaryReplyDao.deleteDiaryReply(Drid,uid);
    }

    @Override
    public void updateLikeCountByDiaryReplyId(int diaryReplyId, int i) {
        diaryReplyDao.updateLikeCountByDiaryReplyId(diaryReplyId,i);
    }

    @Override
    public List<DiaryReply> getDiaryReplyListByDiaryCommentId(int dcId) {
        return diaryReplyDao.getDiaryReplyListByDiaryCommentId(dcId);
    }

    @Override
    public int submitDiaryReply(DiaryReply diaryReply) {
        return diaryReplyDao.insertDiaryReply(diaryReply);
    }

    @Override
    public List<DiaryReply> findDiaryReplyListByUid(int uid) {
        return diaryReplyDao.getDiaryReplyListByUid(uid);
    }

    @Override
    public int deleteDiaryReplyByDiaryReplyId(int diaryReplyId) {
        return diaryReplyDao.deleteDiaryReplyByDiaryReplyId(diaryReplyId);
    }

}
