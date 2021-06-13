package team.sdguys.dao;

import team.sdguys.entity.BookRating;

/**
 * 图书评分表的接口
 */
public interface BookRatingDao {

    /**
     * 查找用户对图书的评分
     * @param uid 用户编号
     * @param bookId 图书编号
     * @return 图书评分实体类
     */
    BookRating getBookRatingByUidAndBookId(int uid, int bookId);

    /**
     * 插入图书评分记录
     * @param uid 用户编号
     * @param bookId 图书编号
     * @param rating 图书评分
     * @return 受影响的行数
     */
    public int insertBookRating(int uid, int bookId, double rating);

    /**
     * 更新用户对图书的评分
     * @param uid 用户编号
     * @param bookId 图书编号
     * @param bookRating 图书评分
     * @return 受影响的行数
     */
    public int updateBookRatingByUidAndBookId(int uid, int bookId, double bookRating);
}
