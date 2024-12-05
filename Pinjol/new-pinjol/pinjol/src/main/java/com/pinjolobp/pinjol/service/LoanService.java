package com.pinjolobp.pinjol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinjolobp.pinjol.entity.Loan;
import com.pinjolobp.pinjol.repository.LoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    // Simpan atau perbarui loan
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // Hapus loan berdasarkan ID
    public void deleteLoanById(Long id) {
        loanRepository.deleteById(id);
    }

    // Ambil semua loan
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // Cari loan berdasarkan status
    public List<Loan> getLoansByStatus(Loan.Status status) {
        return loanRepository.findByStatus(status);
    }

    // Cari loan berdasarkan email
    public List<Loan> getLoansByEmail(String email) {
        return loanRepository.findByEmail(email);
    }

    // Cari loan berdasarkan ID
    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public void updateLoanStatus(Long id, Loan.Status status) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid loan ID"));
        loan.setStatus(status);
        loanRepository.save(loan); // Simpan perubahan status ke database
    }
}