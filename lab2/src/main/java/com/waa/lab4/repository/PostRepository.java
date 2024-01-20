package com.waa.lab4.repository;

import com.waa.lab4.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor_Id(Long id);
}