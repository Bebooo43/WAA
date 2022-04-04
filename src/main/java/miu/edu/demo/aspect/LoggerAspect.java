package miu.edu.demo.aspect;

import miu.edu.demo.domain.Logger;
import miu.edu.demo.domain.Userr;
import miu.edu.demo.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Pointcut("@annotation(miu.edu.demo.aspect.annotation.ExecutionTime)")
    public void logMeAnnotation(){

    }

    @Around("logMeAnnotation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;
        Logger logger = new Logger();
        logger.setOperation(joinPoint.getSignature().getName());
        logger.setDatetime(new Date());
        logger.setDuration(executionTime);
        logger.setPrinciple(Userr.getLoggedInUser());
        loggerService.save(logger);
        return joinPoint.proceed();
    }

}
