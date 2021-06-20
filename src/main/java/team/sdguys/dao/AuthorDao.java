package team.sdguys.dao;

import team.sdguys.entity.Author;

import java.util.List;

/**
 * 有关Author表操作的接口
 */
public interface AuthorDao extends BaseDao{

    /**
     * 通过作者id找到作者
     * @param authorId 作者id
     * @return 作者实体类
     */
    public Author getAuthorByAuthorId(int authorId);


    /**
     * 插入一条书籍作者信息
     * @param author 作者
     * @return 受影响的行数
     */
    public int insertNewAuthor(Author author);

    /**
     * 检索出所有的作者
     * @return
     */
    List<Author> getAuthorList();

    /**
     * 检索作者数量
     * @return
     */
    int getAuthorCount();

    /**
     * 分页查询作者
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Author> getAuthorByPage(int pageNo, int defaultPageSize);

    /**
     * 删除作者信息
     * @param authorId
     * @return
     */
    int deleteAuthorById(int authorId);

    /**
     * 添加作者
     * @param author
     * @return
     */
    int addAuthor(Author author);

    /**
     * 修改作者
     * @param author
     * @return
     */
    int modifyAuthorById(Author author);
}
