package com.waa.lab4.controller;

import com.waa.lab4.dto.CommentDto;
import com.waa.lab4.dto.PostDto;
import com.waa.lab4.dto.UserDto;
import com.waa.lab4.service.CommentService;
import com.waa.lab4.service.PostService;
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
    private final CommentService commentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PostDto> getPost(@PathVariable String id){
        PostDto postDto = postService.getPost(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto, @RequestBody UserDto userDto){
        PostDto createdPostDto = postService.addPost(postDto, userDto);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<>(postService.findAllPosts(), HttpStatus.OK);
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

    @PostMapping("/{postId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentDto> addComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {
        CommentDto createdComment = postService.addComment(postId, commentDto);
        return ResponseEntity.ok(createdComment);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentDto> getComment(@PathVariable Long postId, @PathVariable Long commentId) {
        CommentDto commentDto = commentService.getComment(postId, commentId);
        return ResponseEntity.ok(commentDto);
    }

}
