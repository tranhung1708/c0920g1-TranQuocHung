package vn.codegym;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDateTime;

public class DemoAspect {
    @Pointcut("execution(* com.example.controller.BookController.*delete(..))")
    public void bookControllerDeleteMethod(){}

    @After("bookControllerDeleteMethod()")
    public void afterCallMethodDelete(JoinPoint joinPoint){
        System.err.println("1 book was paid at: " + LocalDateTime.now());
    }
    @Pointcut("execution(* com.example.controller.BookController.*save(..))")
    public void bookControllerSaveMethod(){}

    @After("bookControllerSaveMethod()")
    public void afterCallMethodSave(JoinPoint joinPoint){
        System.err.println("1  book was borrowed at: " + LocalDateTime.now());
    }
}
