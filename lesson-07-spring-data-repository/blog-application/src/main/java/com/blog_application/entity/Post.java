package com.blog_application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="image", nullable=false, length=1000)
    private String image;
    @Column(name="title", nullable=false, length=100)
    private String title;
    @Column(name="summary", nullable=false, length=500)
    private String summary;
    @Column(name="content", nullable=false, length=3000)
    private String content;
    private LocalDateTime postTime;

    public Post() {
    }

    public Post(Long id, String image, String title, String summary, String content, LocalDateTime postTime) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.postTime = postTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }
}
