package com.waa.lab3.repository;

import com.waa.lab3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where size(u.posts) > :n")
    List<User> findUsersWithMoreThanNPosts(@Param("n") int n);
    Optional<User> findById(Long id);
    Optional<User> findUserByName(String name);
}
