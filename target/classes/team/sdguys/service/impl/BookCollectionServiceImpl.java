package team.sdguys.service.impl;

import team.sdguys.dao.BookCollectionDao;
import team.sdguys.dao.impl.BookCollectionDaoImpl;
import team.sdguys.service.BookCollectionService;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书收藏业务接口的实现类
 */
public class BookCollectionServiceImpl implements BookCollectionService {

    BookCollectionDao bookCollectionDao = new BookCollectionDaoImpl();

    @Override
    public List<Integer> findUidListByBookId(int bookId) {
        return bookCollectionDao.getUIdListByBid(bookId);
    }

    @Override
    public List<Integer> findBookIdListByUid(int uid) {
        return bookCollectionDao.getBIdListByUid(uid);
    }

    @Override
    public List<Integer> findOtherBookIdListByUid(int uid, int bookId) {
        List<Integer> uIdList = findUidListByBookId(bookId);
        List<Integer> otherMovieIdList = new ArrayList<Integer>();
        for (Integer uId : uIdList){
            if(uId != uid){
                List<Integer> tempList = findBookIdListByUid(uId);
                otherMovieIdList.addAll(tempList);
            }
        }
        return otherMovieIdList;
    }

    @Override
    public Boolean checkRecordByUidAndBookId(int uid, int bookId) {
        List<Integer> bookIdList = this.findBookIdListByUid(uid);
        // 未收藏
        if(bookIdList.size() == 0) {
            return false;
        }

        for (int mid : bookIdList){
            if(bookId == mid){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public int addBookCollection(int uid, int bookId) {
        return bookCollectionDao.insertBookCollectionByBidAndUid(bookId,uid);
    }

    @Override
    public int deleteBookCollection(int uid, int bookId) {
        return bookCollectionDao.deleteBookCollectionByBidAndUid(bookId,uid);
    }
}
