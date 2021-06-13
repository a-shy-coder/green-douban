package team.sdguys.entity;

import java.util.List;

/**
 * 创建一个Page类，用于封装分页信息
 *
 * @author Anna
 */
public class Page {

    public static final int DEFAULT_PAGE_NO = 1;
    public static final int DEFAULT_PAGE_SIZE = 5;
    public static final int DEFAULT_NAV_SIZE = 5;

    private int pageNo = DEFAULT_PAGE_NO; //当前页码
    private int pageSize = DEFAULT_PAGE_SIZE; //每页显示多少条记录，也就是每页的记录数
    private List dataList; //一个列表，存储查到的当前页的所有记录
    private int totalCount; //总记录数，用于计算分页数量
    private int navSize = DEFAULT_NAV_SIZE; //导航页码数
    
    //添加一个方法，用于计算导航页码
    //返回的是一个数组，包含所有的导航页码
    public int[] getNavPages() { //navPages
        int start = 0, end = 0;
        int a = navSize / 2;
        start = pageNo - a;
        if (navSize % 2 == 0) {
            end = pageNo + a - 1;
        } else {
            end = pageNo + a;
        }
        // 分三种情况处理
        int totalPages = getTotalPages();
        int[] b = new int[navSize];
        // 左边界
        if (start < 1) {
            for (int i = 0, step = 1; i < navSize; i++, step++) {
                if (step <= totalPages) {
                    b[i] = step;
                } else {
                    break;
                }
            }
        } else if (end > totalPages) {	// 右边界
            for (int i = navSize - 1, step = totalPages; i >= 0; i--, step--) {
                if (step > 0) {
                    b[i] = step;
                } else {
                    break;
                }
            }
        } else {	// 中间
            for (int i = 0; i < navSize; i++) {
                b[i] = start++;
            }
        }
        return b;
    }

    //定义一个方法用于获取总页数
    //这里方法名是根据getter的规则命名的，所以在jsp页面上不需要调用该方法，直接写属性名totalPages即可
    public int getTotalPages() { //totalPages
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    //返回下一页的页码
    public int getNextPage() { //nextPage
        if (pageNo >= getTotalPages()) { //如果页码大于等于最后一页的页码，则没有下一页
            return getTotalPages(); //这里返回最后一页的页码作为下一页
        } else {
            return pageNo + 1;
        }
    }

    //返回上一页的页码
    public int getPreviousPage() { //previousPage
        if (pageNo <= 1) { //如果页码小于等于1，则没有上一页
            return 1; //这里返回1作为上一页
        } else {
            return pageNo - 1;
        }
    }

    public Page() {
    }

    public Page(int pageNo, List dataList, int totalCount) {
        this.pageNo = pageNo;
        this.dataList = dataList;
        this.totalCount = totalCount;
    }

    public Page(int pageNo, int pageSize, List dataList, int totalCount, int navSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.dataList = dataList;
        this.totalCount = totalCount;
        this.navSize = navSize;
    }

    public int getPageNo() { //pageNo
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List getDataList() {
        return dataList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getNavSize() {
        return navSize;
    }

}
