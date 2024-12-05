package com.pinjolobp.pinjol.controller;

import com.pinjolobp.pinjol.entity.Loan;
import com.pinjolobp.pinjol.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private LoanService loanService;

    // Menampilkan semua loan
    @GetMapping("/admin/dashboard")
    public String viewLoans(Model model) {
        List<Loan> loans = loanService.getAllLoans();
        for (Loan loan : loans) {
            System.out.println("Loan status: " + loan.getStatus());
        }
        model.addAttribute("loans", loans); 
        return "admin/indexAdmin"; 
    }

        // Update status loan menjadi APPROVED
    @PostMapping("admin/loan/{id}/approve")
    public String approveLoan(@PathVariable Long id) {
        loanService.updateLoanStatus(id, Loan.Status.approved);
        return "redirect:/admin/dashboard"; 
    }

    // Update status loan menjadi REJECTED
    @PostMapping("admin/loan/{id}/reject")
    public String rejectLoan(@PathVariable Long id) {
        loanService.updateLoanStatus(id, Loan.Status.rejected);
        return "redirect:/admin/dashboard";
    }
}
