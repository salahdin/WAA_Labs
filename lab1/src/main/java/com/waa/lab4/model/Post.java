package com.waa.lab4.model;

import lombok.Data;

@Data
public class Post {
    Long id;
    String title;
    String content;
    String author;
}
