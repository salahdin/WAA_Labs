package com.waa.lab2.service;


import com.waa.lab2.dto.PostDto;
import com.waa.lab2.dto.UserDto;
import com.waa.lab2.model.Post;
import com.waa.lab2.model.User;
import com.waa.lab2.repository.PostRepository;
import com.waa.lab2.repository.UserRepository;
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


    public PostDto getPost(String id){
        long id1 = Long.parseLong(id);
        Post post = postRepository.findById(id1).orElseThrow(() -> new RuntimeException("Post with id " + id + " not found"));
        return modelMapper.map(post, PostDto.class);
    }

    public PostDto addPost(PostDto postDto, UserDto userDto){
        Optional<User> existingUser = userRepository.findUserByName(userDto.getName());
        if(existingUser.isEmpty()){
            throw new RuntimeException("User with name " + userDto.getName() + " not found");
        }
        Post post = modelMapper.map(postDto, Post.class);
        post.setAuthor(existingUser.get());
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
