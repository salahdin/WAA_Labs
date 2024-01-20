package com.waa.lab4.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String content;
    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    List<Comment> comments;
}
