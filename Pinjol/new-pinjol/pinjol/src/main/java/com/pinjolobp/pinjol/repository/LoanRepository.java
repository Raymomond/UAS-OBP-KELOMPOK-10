package com.pinjolobp.pinjol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinjolobp.pinjol.entity.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Cari loan berdasarkan status
    List<Loan> findByStatus(Loan.Status status);

    // Cari loan berdasarkan email
    List<Loan> findByEmail(String email);
}