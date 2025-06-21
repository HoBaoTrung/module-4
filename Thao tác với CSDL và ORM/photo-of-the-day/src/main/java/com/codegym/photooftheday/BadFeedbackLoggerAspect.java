package com.codegym.photooftheday;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;
@Aspect
@Component
public class BadFeedbackLoggerAspect {

    private static final Logger LOGGER = Logger.getLogger(BadFeedbackLoggerAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.codegym.photooftheday..*(..))", throwing = "ex")
    public void logBadFeedback(BadFeedbackException ex) {
        Feedback feedback = ex.getFeedback();
        String logMessage = String.format("Phát hiện feedback xấu! Tác giả: %s, Nội dung: %s, Thời gian: %s",
                feedback.getAuthor(),
                feedback.getComment(),
                LocalDateTime.now());

        LOGGER.warning(logMessage);
    }
}