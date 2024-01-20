package com.waa.lab4.aspect;

import com.waa.lab4.model.Log;
import com.waa.lab4.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {
  private final LogRepository logRepository;
  @After("@annotation(com.waa.lab4.annotation.Logger)")
  public void log(JoinPoint joinPoint) {
        Log log = new Log();
        log.setDateTime(LocalDateTime.now());
        log.setOperation(joinPoint.getSignature().getName());
        log.setPrinciple("user");
        logRepository.save(log);
    }

}
