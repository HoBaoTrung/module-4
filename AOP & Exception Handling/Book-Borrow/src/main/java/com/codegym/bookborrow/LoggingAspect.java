package com.codegym.bookborrow;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.codegym.bookborrow.service.MyBookService.borrowBook(..)) || execution(* com.codegym.bookborrow.service.MyBookService.returnBook(..))")
    public void logChange(JoinPoint joinPoint) {
        System.out.println("[LOG] Book state changed: " + joinPoint.getSignature());
    }

    @Before("execution(* com.codegym.bookborrow.controller..*(..))")
    public void logVisitorCount(JoinPoint joinPoint) {
        System.out.println("[VISIT] Truy cập: " + joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* com.codegym.bookborrow.service.MyBookService.borrowBook(..))", throwing = "e")
    public void logBorrowError(Exception e) {
        System.err.println("[ERROR] Mượn sách lỗi: " + e.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* com.codegym.bookborrow.service.MyBookService.returnBook(..))", throwing = "e")
    public void logReturnError(Exception e) {
        System.err.println("[ERROR] Trả sách lỗi: " + e.getMessage());
    }
}
