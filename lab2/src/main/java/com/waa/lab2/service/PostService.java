package com.waa.lab2.service;


import com.waa.lab2.dto.PostDto;
import com.waa.lab2.model.Post;
import com.waa.lab2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    public PostDto getPost(String id){
        long id1 = Long.parseLong(id);
        Post post = postRepository.findById(id1).orElseThrow(() -> new RuntimeException("Post with id " + id + " not found"));
        return modelMapper.map(post, PostDto.class);
    }

    public PostDto addPost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
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
}
