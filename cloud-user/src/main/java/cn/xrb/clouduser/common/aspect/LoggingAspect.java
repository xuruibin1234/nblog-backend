package cn.xrb.clouduser.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* cn.xrb.clouduser.controller..*.*(..))") // 根据实际情况配置包路径
    public void serviceLogging() {}

    @Before("serviceLogging()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "serviceLogging()", returning = "result")
    public void logAfter(Object result) {
        logger.info("Result: " + result.toString());
    }
}
