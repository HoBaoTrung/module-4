package com.codegym.bookborrow.repository;

import com.codegym.bookborrow.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, String> {
}
