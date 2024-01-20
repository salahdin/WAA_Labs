package com.waa.lab2.repository;

import com.waa.lab2.model.Post;
import com.waa.lab2.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user1 = new User();
        user1.setPosts(List.of(new Post(), new Post(), new Post()));
        entityManager.persist(user1);

        User user2 = new User();
        user2.setPosts(List.of(new Post()));
        entityManager.persist(user2);

        User user3 = new User();
        user3.setPosts(List.of(new Post(), new Post()));
        entityManager.persist(user3);

        entityManager.flush();
    }


}