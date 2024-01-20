package com.waa.lab4.aspect;

import com.waa.lab4.model.Log;
import com.waa.lab4.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {
  private final LogRepository logRepository;

  Logger logger = Logger.getLogger(getClass().getName());
  @After("@annotation(com.waa.lab4.annotation.Logger)")
  public void log(JoinPoint joinPoint) {
        Log log = new Log();
        log.setDateTime(LocalDateTime.now());
        log.setOperation(joinPoint.getSignature().getName());
        log.setPrinciple("user");
        logRepository.save(log);
    }

  @Around("@annotation(com.waa.lab4.annotation.ExecutionTime)")
  public Object calulateTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      StopWatch stopWatch = new StopWatch();
      stopWatch.start(proceedingJoinPoint.getSignature().getName());
      Object retVal = proceedingJoinPoint.proceed();
      stopWatch.stop();
      logger.info("Execution time of " + proceedingJoinPoint.getSignature().getName() + "operation is " + stopWatch.getTotalTimeMillis() + "ms");
      return retVal;
  }

}
