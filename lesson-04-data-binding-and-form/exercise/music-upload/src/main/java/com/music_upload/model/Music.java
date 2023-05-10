package com.music_upload.model;

import java.util.List;

public class Music {
    private String name;
    private String singer;
    private List<MusicGenres> genres;
    private String url;

    public Music() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public List<MusicGenres> getGenres() {
        return genres;
    }

    public void setGenres(List<MusicGenres> genres) {
        this.genres = genres;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Music(String name, String singer, List<MusicGenres> genres, String url) {
        this.name = name;
        this.singer = singer;
        this.genres = genres;
        this.url = url;
    }
}
