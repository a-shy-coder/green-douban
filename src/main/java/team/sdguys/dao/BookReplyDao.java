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

    /**
     *根据dcid查找drid
     * @param list
     * @return drid
     */
     List<Integer> getBridlistbyBCId(List<Integer> list);

    /**
     * 根据drid查找dr
     * @param bridlist
     * @return DR
     */
     List<BookReply> getBookReplybybrid(List<Integer> bridlist);

    /**
     * 根据uid查找BRId
     * @param uid
     */
    List<Integer> getBridListbyUid(int uid);




}
