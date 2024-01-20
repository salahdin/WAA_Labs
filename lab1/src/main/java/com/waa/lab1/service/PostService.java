package com.waa.lab1.service;


import com.waa.lab1.repository.PostRepository;
import com.waa.lab1.dto.PostDto;
import com.waa.lab1.model.Post;
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
        Post post = postRepository.findPost(id1);
        if(post == null){
            throw new RuntimeException("Post with id " + id + " not found");
        }
        return modelMapper.map(post, PostDto.class);
    }

    public PostDto addPost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return modelMapper.map(postRepository.addPost(post), PostDto.class);
    }

    public List<PostDto> findAll(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post ->
             modelMapper.map(post, PostDto.class)
        ).toList();
    }

    public PostDto updatePost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        Post updatedPost = postRepository.updatePost(post);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    public void deletePost(String id) {
        long id1 = Long.parseLong(id);
        postRepository.deletePost(id1);
    }

    public List<PostDto> findPostByAuthor(String author){
        List<Post> posts = postRepository.findPostByAuthor(author);
        if(posts.isEmpty()){
            throw new RuntimeException("Post with author " + author + " not found");
        }
        return posts.stream().map(post ->
                modelMapper.map(post, PostDto.class)
        ).toList();
    }
}
