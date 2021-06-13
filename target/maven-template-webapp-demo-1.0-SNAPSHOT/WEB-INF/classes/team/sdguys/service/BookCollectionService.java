package team.sdguys.service;

import java.util.List;

/**
 * 图书收藏业务接口
 */
public interface BookCollectionService {

    /**
     * 通过 图书编号找到 收藏这部图书的用户编号列表
     * @param bookId 图书编号
     * @return 用户编号列表
     */
    public List<Integer> findUidListByBookId(int bookId);

    /**
     * 通过 图书编号 找到用户收藏的图书列表
     * @param uid 用户编号
     * @return 图书id列表
     */
    public List<Integer> findBookIdListByUid(int uid);

    /**
     * 找到收藏此图书的其他用户的图书收藏列表
     * @param uid 用户编号
     * @param bookId 图书编号
     * @return 其他用户的图书id列表
     */
    public List<Integer> findOtherBookIdListByUid(int uid, int bookId);


    /**
     * 根据 uid 和 bookId 判断当前用户是否收藏了该图书
     * @param uid 用户编号
     * @param bookId 图书标号
     * @return true 收藏了  false 未收藏
     */
    public Boolean checkRecordByUidAndBookId(int uid, int bookId);

    /**
     * 添加图书收藏
     * @param uid 用户编号
     * @param bookId 图书编号
     * @return 受影响的行数
     */
    public int addBookCollection(int uid, int bookId);

    /**
     * 删除图书收藏
     * @param uid 用户编号
     * @param bookId 图书编号
     * @return 受影响的行数
     */
    public int deleteBookCollection(int uid, int bookId);


}
