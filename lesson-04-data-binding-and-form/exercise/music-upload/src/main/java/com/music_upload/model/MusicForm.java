package com.music_upload.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MusicForm {
    private String name;
    private String singer;
    private List<MusicGenres> genres;
    private MultipartFile url;

    public MusicForm() {
    }

    public MusicForm(String name, String singer, List<MusicGenres> genres, MultipartFile url) {
        this.name = name;
        this.singer = singer;
        this.genres = genres;
        this.url = url;
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

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}
