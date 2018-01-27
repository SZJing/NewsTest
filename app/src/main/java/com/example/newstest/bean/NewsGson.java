package com.example.newstest.bean;

import java.util.List;

/**
 * Created by sl on 2018/1/24.
 */

public class NewsGson {
    private int code;
    private String msg;
    private List<News> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<News> getNewsList() {
        return newslist;
    }

    public void setNewsList(List<News> newsList) {
        this.newslist = newsList;
    }

    public static class News{
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public News(String ctime, String description, String picUrl, String title, String url) {
            this.ctime = ctime;
            this.description = description;
            this.picUrl = picUrl;
            this.title = title;
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getNewUrl() {
            return url;
        }

        public void setNewUrl(String newUrl) {
            this.url = newUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTime() {
            return ctime;
        }

        public void setTime(String time) {
            this.ctime = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
