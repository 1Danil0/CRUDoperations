package com.danilermolenko.spring.mvc_rest_hibernate.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentLoggingAspect {
    @Pointcut("execution (public * com.danilermolenko.spring.mvc_rest_hibernate.dao.StudentDAOImpl.*(..))")
    public void allStudentDAOImplMethods(){}

    @Around("allStudentDAOImplMethods()")
    public Object aroundStudentDAOMethodsAdvice(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Start of " + signature.getName() + " method");
        System.out.println(signature.getMethod());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of " + signature.getName() + " method");
        System.out.println("--------------------------------------------------------------------------");
        return result;
    }
}
