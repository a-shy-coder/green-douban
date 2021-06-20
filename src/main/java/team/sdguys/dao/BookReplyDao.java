package team.sdguys.dao;
import team.sdguys.entity.BookReply;

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

    /**
     * 更新图书回复点赞数量
     * @param bookReplyId 图书回复编号
     * @param i 增加的点赞数量 1代表增加1 -1代表减少1 直接 +=i 即可
     * @return
     */
    int updateLikeCountByBookReplyId(int bookReplyId, int i);


    /**
     * 根据评论编号查找所有的回复
     * @param bcId 评论编号
     * @return 图书回复列表
     */
    List<BookReply> getBookReplyListByBookCommentId(int bcId);

    /**
     * 根据uid查找该用户的所有回复
     * @param uid 用户编号
     * @return 评论列表
     */
    List<BookReply> getBookReplyListByUid(int uid);

    /**
     * 根据回复编号删除回复
     * @param bookReplyId 回复编号
     * @return 受影响的行数
     */
    int deleteBookReplyByBookReplyId(int bookReplyId);
}
