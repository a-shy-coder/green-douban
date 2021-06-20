package team.sdguys.entity;

import java.util.List;

/**
 * 创建一个Result类，用于封装使用wangEditor富文本编辑器上传本地文件返回的数据
 *
 */
public class Result {

    private int errno; //错误代码，0表示没有错误
    private List<Image> data; //一个列表，封装上传的图片的信息，每个图片的信息用一个Image对象封装

    public Result(int errno, List<Image> data) {
        this.errno = errno;
        this.data = data;
    }
    
    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public List<Image> getData() {
        return data;
    }

    public void setData(List<Image> data) {
        this.data = data;
    }
            
}
