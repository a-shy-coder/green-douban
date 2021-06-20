package team.sdguys.service.impl;

import team.sdguys.dao.DiaryCommentDao;
import team.sdguys.dao.impl.DiaryCommentDaoImpl;
import team.sdguys.entity.DiaryComment;
import team.sdguys.service.DiaryCommentService;

import java.util.List;

public class DiaryCommentServiceImpl implements DiaryCommentService {
    DiaryCommentDao diaryCommentDao = new DiaryCommentDaoImpl();
    @Override
    public List<Integer> getdcidlistbydid(int did) {
        return diaryCommentDao.getdcidlistbydid(did);
    }

    @Override
    public List<DiaryComment> getDClistbydcidlist(List<Integer> list) {
        return diaryCommentDao.getDClistbydcidlist(list);
    }

    @Override
    public List<Integer> getdcidbyuid(int uid) {
        return diaryCommentDao.getdcidbyuid(uid);
    }

    @Override
    public int insertnewDiaryComment(DiaryComment diaryComment) {
        return diaryCommentDao.InsertDiaryComment(diaryComment);
    }

    @Override
    public int updateDiaryComment(String dcContent,int uid, int dcid) {
        return diaryCommentDao.updateDiaryComment(dcContent,uid,dcid);
    }

    @Override
    public int deleteDiaryComment(int dcid,int uid) {
        return diaryCommentDao.deleteDiaryComment(dcid,uid);
    }

    @Override
    public int addoneDCLikeCount(int DCId) {
        return diaryCommentDao.addoneDCLikeCount(DCId);
    }

    @Override
    public int suboneDCLikeCount(int DCId) {
        return diaryCommentDao.suboneDCLikeCount(DCId);
    }

    @Override
    public List<DiaryComment> getDiaryCommentListByDiaryId(int diaryId) {
        return diaryCommentDao.getDiaryCommentListByDiaryId(diaryId);
    }

    @Override
    public int submitDiaryComment(DiaryComment diaryComment) {
        return diaryCommentDao.InsertDiaryComment(diaryComment);
    }

    @Override
    public void updateLikeCountByDiaryCommentId(int diaryCommentId, int i) {
        diaryCommentDao.updateLikeCountByDiaryCommentId(diaryCommentId, i);
    }

    @Override
    public DiaryComment findDiaryCommentByDiaryCommentId(int dcId) {
        return diaryCommentDao.getDiaryCommentByDiaryCommentId(dcId);

    }

    @Override
    public List<DiaryComment> findDiaryCommentListByUid(int uid) {
        return diaryCommentDao.getDiaryCommentListByUid(uid);
    }

}
