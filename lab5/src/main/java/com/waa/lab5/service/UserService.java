package com.waa.lab5.service;

import com.waa.lab5.dto.UserDto;
import com.waa.lab5.repository.UserRepository;
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