package com.waa.lab3.repository;

import com.waa.lab3.model.Post;
import com.waa.lab3.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void findUsersWithMoreThanNPosts_returnsUsersWithMoreThanTwoPosts() {
        List<User> users = userRepository.findUsersWithMoreThanNPosts(2);

        assertThat(users).hasSize(1);
    }

    @Test
    public void findUsersWithMoreThanNPosts_returnsUsersWithMoreThanZeroPosts() {
        List<User> users = userRepository.findUsersWithMoreThanNPosts(0);

        assertThat(users).hasSize(3);
    }

    @Test
    public void findUsersWithMoreThanNPosts_returnsEmptyListWhenNIsTooLarge() {
        List<User> users = userRepository.findUsersWithMoreThanNPosts(10);
        assertThat(users).isEmpty();
    }
}