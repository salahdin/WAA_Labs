package com.waa.lab4.service;

import com.waa.lab4.dto.UserDto;
import com.waa.lab4.model.User;
import com.waa.lab4.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(user -> new UserDto(user.getName())).toList();
    }
}