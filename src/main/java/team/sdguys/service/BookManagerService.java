package team.sdguys.service;

import team.sdguys.entity.Book;

public interface BookManagerService {
    /**
     * 添加新图书
     * @param book 新图书
     * @return
     */
    public int addWholeBook(Book book);

    /**
     * 根据id删除图书
     * @param bid 图书id
     * @return 影响的行数
     */
    public int deleteBookById(int bid);
}
