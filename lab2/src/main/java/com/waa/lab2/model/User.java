package com.waa.lab2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    long id;
    String name;
    @OneToMany(mappedBy = "author")
    List<Post> posts;

    @Override
    public String toString() {
        return this.name;
    }
}
