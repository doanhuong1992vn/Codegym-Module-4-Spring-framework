package com.blog_application.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image", nullable = false, length = 2000)
    private String image;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "summary", nullable = false, length = 500)
    private String summary;
    @Column(name = "content", nullable = false, length = 3000)
    private String content;
    private LocalDateTime postTime;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
