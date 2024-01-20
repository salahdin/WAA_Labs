package com.waa.lab4.repository;

import com.waa.lab4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where size(u.posts) > 1")
    List<User> findUsersWithMoreThanOnePost(@Param("n") int n);
    Optional<User> findById(Long id);
    Optional<User> findUserByName(String name);
}
