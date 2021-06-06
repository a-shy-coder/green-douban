package team.sdguys.service;

import team.sdguys.entity.Author;

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
}
