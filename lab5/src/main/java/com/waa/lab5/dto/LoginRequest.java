package com.waa.lab5.dto;

import lombok.*;

@Data
@Builder
public class LoginRequest {
    String username;
    String password;
}
