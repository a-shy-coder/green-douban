package team.sdguys.dao;

import team.sdguys.entity.Book;
import team.sdguys.entity.Book;

import java.util.List;

/**
 * 图书表接口, 针对图书表的一些操作
 */
public interface BookDao extends BaseDao {

    /**
     * 插入一条书籍信息
     * @param book 书籍
     * @return 受影响的行数
     */
    int insertBook(Book book);


    /**
     * 通过图书id获取该图书的所有信息
     * @param BId 图书Id
     * @return 该id对应的Book实体类
     */
    Book getBookByBId(int BId);


    /**
     * 根据图书种类检索图书id列表
     * @param BType 图书类型
     * @return 图书id列表
     */
    List<Integer> getBIdListByBType(String BType);

    /**
     * 根据出版社检索该出版社所发行图书id列表
     * @param  BPublisher 出版社
     * @return 图书id列表
     */
    List<Integer> getBIdListByBPublisher(String BPublisher);


    /**
     * 根据作者id检索该作者所写图书id列表
     * @param AuthorId 作者id
     * @return 图书id列表
     */
    List<Integer> getBIdListByAuthorId(int AuthorId);


    /**
     * 根据图书中文名获得Bid
     * @param BChineseName 图书中文名
     * @return 图书Bid
     */
    int getBIdByBChineseName(String BChineseName);

    /**
     * 根据图书原名获得Bid
     * @param BOriginName 图书原名
     * @return 图书Bid
     */
    int getBIdByBOriginName(String BOriginName);


    /**
     * 根据关键词检索图书列表
     * @param KeyWord 关键词
     * @return 图书列表
     */
    List<Book> getBookListByKeyword(String KeyWord);

    /**
     * 根据图书编号Bid删除图书
     * @param Bid 图书编号
     * @return 受影响的行数
     */
    int deleteBookByBid(int Bid);

    /**
     * 修改图书信息
     * @param book 图书实体类
     * @return 受影响的行数
     */
    int updateBook(Book book);

    /**
     * 按评分从大到小排序获得所有图书信息
     * @return 图书列表
     */
    List<Book> getAllBooksOrderByRatingDesc();

    /**
     * 按评分从到小到大排序获得所有图书信息
     * @return 图书列表
     */
    List<Book> getAllBooksOrderByRatingEsc();


    /**
     * 按发行日期从新到旧获得所有图书信息
     * @return 图书列表
     */
    List<Book> getAllBooksOrderByReleaseDateDesc();

    /**
     * 更新图书评分和评分人数
     * @param bookId 图书编号
     * @param bookRating 图书评分
     * @param bookRatingCount 图书评分人数
     * @return 受影响的行数
     */
    int updateBookRatingAndBookRatingCountByBookId(int bookId, double bookRating,int bookRatingCount);
    
    /**
     * 找到作者拍摄的最受欢迎的5部图书
     * @param authorId 作者编号
     * @return 最受欢迎的5部图书列表
     */
    List<Book> getTheTop5HighestRatedBooksByAuthorId(int authorId);

    /**
     * 找到作者拍摄的最新的5部图书
     * @param authorId 作者编号
     * @return 最新的5部图书列表
     */
    List<Book> getTheLatest5BooksByAuthorId(int authorId);
}
