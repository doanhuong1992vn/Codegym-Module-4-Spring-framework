package com.blog_application.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Post> posts;
}
