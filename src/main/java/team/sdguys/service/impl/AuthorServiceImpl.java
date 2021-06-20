package team.sdguys.service.impl;

import team.sdguys.dao.AuthorDao;
import team.sdguys.dao.impl.AuthorDaoImpl;
import team.sdguys.entity.Author;
import team.sdguys.service.AuthorService;

import java.util.List;

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

    @Override
    public List<Author> getAuthorList() {
        return authorDao.getAuthorList();
    }

    @Override
    public List<Author> findAuthorByPage(int pageNo, int defaultPageSize) {
        return authorDao.getAuthorByPage(pageNo,defaultPageSize);
    }

    @Override
    public int getAuthorCount() {
        return authorDao.getAuthorCount();
    }

    @Override
    public int deleteAuthorById(int authorId) {
        return authorDao.deleteAuthorById(authorId);
    }

    @Override
    public int addAuthor(Author author) {
        return authorDao.addAuthor(author);
    }

    @Override
    public int modifyAuthorById(Author author) {
        return authorDao.modifyAuthorById(author);
    }
}
