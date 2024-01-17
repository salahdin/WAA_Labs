package com.waa.lab1.repository;

import com.waa.lab1.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    final ModelMapper modelMapper;
    List<Post> posts = new ArrayList<>();
    public List<Post> findAll(){
        return posts;
    }

    public Post findPost(long id){
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }

    public Post addPost(Post post){
        String id = String.valueOf(posts.size() + 1);
        if(posts.stream().anyMatch(post1 -> post1.getId().equals(id))){
            throw new RuntimeException("Post with id " + id + " already exists");
        }
        post.setId(Long.parseLong(id));
        posts.add(post);
        return post;
    }

    public void deletePost(long id){
        posts.removeIf(post -> post.getId().equals(id));
    }

    public List<Post> findPostByAuthor(String author){
        return posts.stream().filter(post -> post.getAuthor().equals(author)).toList();
    }

    public Post updatePost(Post post){
        Optional<Post> postOptional = posts.stream().filter(post1 -> post1.getId().equals(post.getId())).findFirst();
        if(postOptional.isEmpty()){
            throw new RuntimeException("Post with id " + post.getId() + " not found");
        }
        Post post1 = postOptional.get();
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setAuthor(post.getAuthor());
        return post1;
    }
}
