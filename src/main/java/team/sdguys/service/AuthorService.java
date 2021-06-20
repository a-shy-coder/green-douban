package team.sdguys.service;

import team.sdguys.entity.Author;

import java.util.List;

/**
 * 作者业务接口
 */
public interface AuthorService {

    /**
     * 根据作者id找到作者实体
     * @param authorId 作者id
     * @return 作者实体
     */
    public Author findAuthorByAuthorId(int authorId);

    /**
     * 添加新图书作者
     * @param author 新作者
     * @return
     */
    public int addNewAuthor(Author author);

    /**
     * 检索出所有的作者
     * @return
     */
    List<Author> getAuthorList();

    /**
     * 分页查询作者
     * @param pageNo
     * @param defaultPageSize
     * @return
     */
    List<Author> findAuthorByPage(int pageNo, int defaultPageSize);

    /**
     * 分页查询作者数量
     * @return
     */
    int getAuthorCount();

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
     * 修改作者信息
     * @param author
     * @return
     */
    int modifyAuthorById(Author author);
}
