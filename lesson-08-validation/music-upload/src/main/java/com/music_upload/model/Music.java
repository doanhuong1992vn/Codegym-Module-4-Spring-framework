package com.music_upload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{not-blank}")
    @Pattern(regexp = "^(?!.*[@;,.=+\\-#%^*}{\\\\/<>])(.{1,800})$", message = "{name-pattern}")
    private String name;
    @NotBlank(message = "{not-blank}")
    @Pattern(regexp = "^(?!.*[@;,.=+\\-#%^*}{\\\\/<>])(.{1,300})$", message = "{singer-pattern}")
    private String singer;
    @NotBlank(message = "{not-blank}")
    @Pattern(regexp = "^(?!.*[@;.=+\\-#%^*}{\\\\/<>])(.{1,1000})$", message = "{genre-pattern}")
    private String genre;
    @NotBlank(message = "{not-blank}")
    @Pattern(regexp = "^(.{1,1000})(\\.mp3|\\.wav|\\.m4p|\\.ogg)$", message = "{url-pattern}")
    private String url;

    public Music() {
    }
    public Music(Long id, String name, String singer, String genre, String url) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genres) {
        this.genre = genres;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
