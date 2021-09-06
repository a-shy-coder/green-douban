package team.sdguys.service.impl;

import team.sdguys.dao.MovieCollectionDao;
import team.sdguys.dao.impl.MovieCollectionDaoImpl;
import team.sdguys.entity.Movie;
import team.sdguys.service.MovieCollectionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 电影收藏业务的实现类
 */
public class MovieCollectionServiceImpl implements MovieCollectionService {

    MovieCollectionDao movieCollectionDao = new MovieCollectionDaoImpl();

    @Override
    public List<Integer> findUidListByMovieId(int movieId) {
        return movieCollectionDao.getUidListByMovieId(movieId);
    }

    @Override
    public List<Integer> findMovieIdListByUid(int uid) {
        return movieCollectionDao.getMovieIdListByUid(uid);
    }

    @Override
    public List<Integer> findOtherMovieIdListByUid(int uid, int movieId) {
        List<Integer> uIdList = findUidListByMovieId(movieId);
        List<Integer> otherMovieIdList = new ArrayList<>();
        Set<Integer> movieIdSet = new HashSet<>();
        for (Integer uId : uIdList){
            if(uId != uid){
                List<Integer> tempList = findMovieIdListByUid(uId);
                for (Integer mid : tempList){
                    if(!movieIdSet.contains(mid) && mid != movieId){
                        movieIdSet.add(mid);
                    }
                }
            }
        }
        otherMovieIdList.addAll(movieIdSet);
        return otherMovieIdList;
    }

    @Override
    public Boolean checkRecordByUidAndMovieId(int uid, int movieId) {

        List<Integer> movieIdList = this.findMovieIdListByUid(uid);
        // 未收藏
        if(movieIdList.size() == 0) {
            return false;
        }

        for (int mid : movieIdList){
            if(movieId == mid){
                return true;
            }
        }
        return false;
    }

    @Override
    public int addMovieCollection(int uid, int movieId) {
        return movieCollectionDao.addMovieCollection(uid, movieId);
    }

    @Override
    public int deleteMovieCollection(int uid, int movieId) {
        return movieCollectionDao.deleteMovieCollectionByUidAndMovieId(uid, movieId);
    }
}
