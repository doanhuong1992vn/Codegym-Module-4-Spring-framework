package com.blog_application.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Post> posts;

    public Category(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return getName();
    }
}
