package team.sdguys.entity;

/**
 * 用于wangEditor上传图片，封装上传的每张图片的三项信息（url、alt、href）
 */
public class Image {

    //图片的路径
    private String url;
    //图片的替换文本
    private String alt;
    //图片的跳转链接
    private String href;

    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    
}
