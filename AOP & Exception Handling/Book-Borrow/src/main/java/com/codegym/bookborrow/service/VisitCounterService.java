package com.codegym.bookborrow.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class VisitCounterService {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increase() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}