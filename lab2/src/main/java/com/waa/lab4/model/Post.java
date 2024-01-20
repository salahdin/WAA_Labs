package com.waa.lab4.model;

import jakarta.persistence.*;
import lombok.*;

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
}
