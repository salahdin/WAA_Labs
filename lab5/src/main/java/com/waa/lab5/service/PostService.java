package com.waa.lab5.service;


import com.waa.lab5.annotation.ExecutionTime;
import com.waa.lab5.annotation.Logger;
import com.waa.lab5.dto.CommentDto;
import com.waa.lab5.dto.PostDto;
import com.waa.lab5.dto.UserDto;
import com.waa.lab5.model.Comment;
import com.waa.lab5.model.Post;
import com.waa.lab5.model.User;
import com.waa.lab5.repository.PostRepository;
import com.waa.lab5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @ExecutionTime
    public PostDto getPost(String id){
        long id1 = Long.parseLong(id);
        Post post = postRepository.findById(id1).orElseThrow(() -> new RuntimeException("Post with id " + id + " not found"));
        return modelMapper.map(post, PostDto.class);
    }

    @Logger
    public PostDto addPost(PostDto postDto, UserDto userDto){
        User existingUser = userRepository.findUserByName(userDto.getName())
                .orElseThrow(() -> new RuntimeException("User with name " + userDto.getName() + " not found"));
        Post post = modelMapper.map(postDto, Post.class);
        post.setAuthor(existingUser);
        return modelMapper.map(postRepository.save(post), PostDto.class);
    }

    public List<PostDto> findAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post ->
             modelMapper.map(post, PostDto.class)
        ).toList();
    }

    public PostDto updatePost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        Post updatedPost = postRepository.save(post);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    public void deletePost(String id) {
        long id1 = Long.parseLong(id);
        postRepository.deleteById(id1);
    }

    public CommentDto addComment(Long postId, CommentDto commentDto) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Comment comment = modelMapper.map(commentDto, Comment.class);
            post.getComments().add(comment);
            postRepository.save(post);
            return modelMapper.map(comment, CommentDto.class);
        } else {
            throw new IllegalArgumentException("Post with id " + postId + " not found");
        }
    }
}
