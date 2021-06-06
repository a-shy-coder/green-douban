package team.sdguys.dao;

import team.sdguys.entity.BookCollection;

import java.util.List;

public interface BookCollectionDao extends BaseDao{

    /**
     * 根据BCollectionId查找BookCollection
     * @param bCollectionId 图书收藏编号
     * @return 对应的 图书收藏BookCollection 实体类
     */
    BookCollection getBookCollectionByBCollectionId(int bCollectionId);

    /**
     * 根据UId查找其收藏了哪些书
     * @param uid 用户Id
     * @return 用户收藏图书列表
     */
    List<Integer> getBIdListByUid(int uid);

    /**
     * 根据BId检索该书被谁收藏
     * @param bid 图书id
     * @return 收藏该图书的用户列表
     */
    List<Integer> getUIdListByBid(int bid);

    /**
     * 根据UId检索其收藏的数量
     * @param uid 用户编号
     * @return 收藏数量
     */
    int getBookCollectionCountByUid(int uid);


    /**
     * 检索出收藏量前5的Bid列表
     * @return Bid列表
     */
    List<Integer> getTop5Bid();

    /**
     * 根据图书编号 和 用户编号 移除收藏
     * @param bid 图书编号
     * @param uid 用户编号
     * @return 受影响的行数
     */
    int deleteBookCollectionByBidAndUid(int bid, int uid);

    /**
     * 根据图书编号 和用户编号 添加收藏
     * @param bid 图书编号
     * @param uid 用户编号
     * @return 受影响的行数
     */
    int insertBookCollectionByBidAndUid(int bid, int uid);

    /**
     *  获取8本数
     */
    List<Integer> get8Bid(int uid);





}
