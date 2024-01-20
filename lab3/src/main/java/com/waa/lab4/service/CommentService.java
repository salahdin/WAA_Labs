package com.waa.lab4.service;

import com.waa.lab4.dto.CommentDto;
import com.waa.lab4.model.Comment;
import com.waa.lab4.repository.CommentRepository;
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
