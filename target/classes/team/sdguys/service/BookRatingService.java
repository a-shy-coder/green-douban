package team.sdguys.service;

/**
 * 图书评分业务接口
 */
public interface BookRatingService {
    /**
     * 找到指定用户对指定图书的评分
     * @param uid 用户编号
     * @param bookId 图书编号
     * @return 图书评分
     */
    public double findBookRatingByUidAndBookId(int uid, int bookId);

    /**
     * 修改指定用户对图书的评分, 如果还未评分, 则插入一条记录
     * @param uid 用户编号
     * @param bookId 图书编号
     * @param bookRating 图书评分
     * @return 受影响的行数
     */
    public int modifyBookRating(int uid, int bookId, double bookRating);
}
