package com.qf.entity;

/**
 * Created by lenovo on 2016/9/10.
 */
public class NewsEntity {

    /**
     * status : 1
     * searchKey : 你全家的健康我包了！
     * recommend : 0
     * id : 1043
     * category : 0
     * title : 你全家的健康我包了！
     * content : 买FitTime会员送价值235元父母体检套餐1份
     * photo : ft-info/hd_dhlctaa_0.jpg
     * url : http://ft-web.fit-time.com/1043.html?id=1043
     * origUrl : http://news.fit-time.cn/?p=8493
     * author : FitTime美小编
     * authorId : 246080
     * createTime : 1473329960000
     * startTime : 1473329959000
     * readCount : 6027
     * shareCount : 30
     * praiseCount : 19
     * favCount : 11
     * commentCount : 4
     * ipc : 442
     * ifc : 75
     */

    private int status;
    private int id;
    private String title;
    private String content;
    private String photo;
    private String url;
    private String origUrl;
    private String author;
    private int readCount;
    private int shareCount;
    private int praiseCount;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrigUrl() {
        return origUrl;
    }

    public void setOrigUrl(String origUrl) {
        this.origUrl = origUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }
}
