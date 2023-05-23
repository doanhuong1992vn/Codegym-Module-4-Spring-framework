package com.blog_application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "category")
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
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss a")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime postTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
