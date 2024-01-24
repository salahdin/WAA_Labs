package com.waa.lab5.repository;

import com.waa.lab5.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor_Id(Long id);

    List<Post> findByTitleContains(String title);
}