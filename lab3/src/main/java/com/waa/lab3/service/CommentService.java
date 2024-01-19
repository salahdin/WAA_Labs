package com.waa.lab3.service;

import com.waa.lab3.dto.CommentDto;
import com.waa.lab3.model.Comment;
import com.waa.lab3.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentDto getComment(Long post_id, Long id) {
        Optional<Comment> comment =  commentRepository.findById(id);
        if(comment.isEmpty()){
            throw new RuntimeException("Comment with id " + id + " not found");
        }
        return modelMapper.map(comment.get(), CommentDto.class);
    }
}
