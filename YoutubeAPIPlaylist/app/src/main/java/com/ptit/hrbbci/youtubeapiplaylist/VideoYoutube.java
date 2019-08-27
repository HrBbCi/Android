package com.ptit.hrbbci.youtubeapiplaylist;

public class VideoYoutube {
    private String title, thumbnails, id;

    public VideoYoutube(String title, String thumbnails, String id) {
        this.title = title;
        this.thumbnails = thumbnails;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
