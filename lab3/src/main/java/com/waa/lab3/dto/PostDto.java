package com.waa.lab3.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    String title;
    String content;
    String author;
    List<CommentDto> commentDtoList;
}
