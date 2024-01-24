package com.waa.lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue
    private Long id;
    private String operation;
    private String principle;
    private LocalDateTime dateTime;


}
