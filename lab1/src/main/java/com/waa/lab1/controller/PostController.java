package com.waa.lab1.controller;

import com.waa.lab1.dto.PostDto;
import com.waa.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PostDto> getPost(@PathVariable String id){
        PostDto postDto = postService.getPost(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto){
        PostDto createdPostDto = postService.addPost(postDto);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto){
        PostDto updatedPostDto = postService.updatePost(postDto);
        return new ResponseEntity<>(updatedPostDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePost(@PathVariable String id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PostDto>> findPostByAuthor(@PathVariable String author){
        return new ResponseEntity<>(postService.findPostByAuthor(author), HttpStatus.OK);
    }
}
