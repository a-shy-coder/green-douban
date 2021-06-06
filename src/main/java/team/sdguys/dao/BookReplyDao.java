package team.sdguys.dao;
import team.sdguys.entity.BookReply;
import java.util.Date;
import java.util.List;

public interface BookReplyDao extends BaseDao{

    /**
     * 根据BRId检索回复
     * @param BRId 书籍回复id
     * @return bookreply
     */
    BookReply getBookReplyByBRId(int BRId);

    /**
     * 根据BCId检索其下方的所有BRId
     * @param BCId 书籍评论id
     * @return BRid的List列表
     */
    List<Integer> getBRIdListByBCId(int BCId);

    /**
     * 新增一条回复
     * @return 修改的行数
     */
    int insertReply(BookReply bookReply);

    // 以下为新增的需要实现的接口



}
