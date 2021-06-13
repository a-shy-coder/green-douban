package team.sdguys.test.dao;

import team.sdguys.dao.AuthorDao;
import team.sdguys.dao.impl.AuthorDaoImpl;
import team.sdguys.entity.Author;

public class AuthorDaoTest {
    public static void main(String[] args) {
        AuthorDao authorDao = new AuthorDaoImpl();
        Author author = authorDao.getAuthorByAuthorId(1);
    }
}
