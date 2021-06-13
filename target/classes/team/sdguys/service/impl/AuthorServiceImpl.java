package team.sdguys.service.impl;

import team.sdguys.dao.AuthorDao;
import team.sdguys.dao.impl.AuthorDaoImpl;
import team.sdguys.entity.Author;
import team.sdguys.service.AuthorService;

/**
 * 作者业务接口的实现类
 */
public class AuthorServiceImpl implements AuthorService {

    AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public Author findAuthorByAuthorId(int authorId) {
        return authorDao.getAuthorByAuthorId(authorId);
    }

    @Override
    public int addNewAuthor(Author author) {
        return authorDao.insertNewAuthor(author);
    }
}
