package team.sdguys.dao;

import team.sdguys.entity.Author;

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
}
