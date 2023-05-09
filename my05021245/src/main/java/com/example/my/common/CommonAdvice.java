package com.example.my.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect //AOP
public class CommonAdvice {

    //@Before("execution(public * com.example.my..controller..*(..))")
    //@Before("within(com.example.my..controller.*)")
    //@Before("bean(*ControllerApi*)")
//    public void tempAdvice(){
//        log.warn("요청이 들어왔습니다.");
//    }

    //findbyidx할 때 넣기 AOP
    @Around("execution(* com.example.my.todo.repository..findByIdx(..))")
    public Object checkFindByIdx(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // log.warn("findByIdx 체크 중");
        // proceedingJoinPoint.proceed() -> 레파지토리의 findByIdx 함수 그 자체
        // proceedingJoinPoint.getareds() -> 레파지토리의 findByIdx 매개뱐수 그 자체
        Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        if(result==null){
            throw new EntityNotFoundException("해당하는 데이터가 없습니다.!");
        }
        return result;
    }
}
