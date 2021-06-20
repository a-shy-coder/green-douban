package team.sdguys.service;

import team.sdguys.entity.Book;

import java.util.List;

public interface BookService {

    /**
     * 通过中文名找到编号
     * @param bookChineseName 书本中文名
     * @return 书本编号
     */
    public int findBookIdByBookChineseName(String bookChineseName);

    /**
     * 通过书籍编号找到书籍
     * @param bookId 书籍编号
     * @return 书籍实体类
     */
    public Book findBookByBookId(int bookId);

    /**
     * 通过图书id列表找到图书列表
     * @param bookIdList 图书id列表
     * @return 图书列表
     */
    public List<Book> findBookListByBookIdList(List<Integer> bookIdList);

    /**
     * 根据用户评分修改图书的总评分
     * @param rating 用户评分
     * @param bookId 图书编号
     * @param uid 用户编号
     */
    public void modifyBookRatingByBookId(double rating, int bookId, int uid);

    /**
     * 通过图书id找到图书
     * @param bookId 图书id
     * @return 图书实体类
     */
    public Book findBookById(int bookId);

    /**
     * 找到作者拍摄的最受欢迎的5部电影
     * @param authorId 作者编号
     * @return 最受欢迎的5部电影列表
     */
    public List<Book> findTheTop5HighestRatedBooksByAuthorId(int authorId);

    /**
     * 找到作者拍摄的最新的5部电影
     * @param authorId 作者编号
     * @return 最新的5部电影列表
     */
    public List<Book> findTheLatest5BooksByAuthorId(int authorId);

    /**
     * 分页查询书籍列表
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Book> findBookByPage(int pageNo, int defaultPageSize);

    /**
     * 查询书籍本数
     * @return
     */
    int getBookCount();


    /**
     * 删除书籍
     * @param bookId
     * @return
     */
    int deleteBookById(int bookId);

    /**
     * 发布图书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    int modifyBookById(Book book);

    /**
     * 修改图书作者
     * @param bookId
     * @param authorId
     * @return
     */
    int modifyBookAuthorByBookId(int bookId, int authorId);
}
