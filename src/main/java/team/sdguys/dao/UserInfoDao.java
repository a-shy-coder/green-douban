package team.sdguys.dao;

import team.sdguys.entity.UserInfo;
import java.util.List;

/**
 * UserInfoDao类，包含对UserInfo表的增删改查操作
 *
 */
public interface UserInfoDao extends BaseDao{

    /**
     * 插入一条新记录到表UserInfo中
     *
     * @param UserInfo 包含要插入的信息的UserInfo对象
     * @return 一个整数值，标识是否插入成功，如果数字小于等于0，则表示插入失败，否则表示受影响的行数
     */
    public int insert(UserInfo UserInfo);
    /**
     * 更新一个用户信息，该方法允许修改除了Uid的用户信息
     *
     * @param UserInfo 包含用户信息更新后的信息的UserInfo对象
     * @return 一个整数值，标识是否更新成功，如果数字小于等于0，则表示更新失败，否则表示受影响的行数
     */
    public int update(UserInfo UserInfo);

    /**
     * 从UserInfo表中删除指定Uid的用户的信息
     *
     * @param id 要删除的用户的Uid
     * @return 一个整数值，标识是否删除成功，若返回值大于0，表示受影响的行数，否则表示未删除任何记录
     */
    public int delete(int id);

    /**
     * 根据id查询单个用户的所有信息
     *
     * @param id 要查询的学生的学号
     * @return 包含所查询的学生的所有信息的Student对象
     */
    public UserInfo getOneById(int id);

     /**
     * 查询男性用户的总人数
     *
     * @return 男性人数
     */
    public int getManSize();

    /**
     * 查询男性用户的总人数
     *
     * @return 女性人数
     */
    public int getWomanSize();

    
     /**
     * 根据页码以及每页记录数查询用户信息列表
     *
     * @param pageNo 页码，也就是第几页，从1开始
     * @param pageSize 页面大小，也就是每页显示的记录数量
     * @return 所查询的学生的列表
     */
    public List<UserInfo> getListByPage(int pageNo,int pageSize);

    /**
     * 查询UserInfo表中所有用户的信息
     *
     * @return 包含所有信息的列表
     */
    public List<UserInfo> getAll();
}
