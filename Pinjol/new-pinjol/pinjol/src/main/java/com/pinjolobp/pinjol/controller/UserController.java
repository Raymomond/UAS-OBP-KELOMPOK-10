package com.pinjolobp.pinjol.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pinjolobp.pinjol.entity.Loan;
import com.pinjolobp.pinjol.service.LoanService;

@Controller
public class UserController {
    @GetMapping("/user/dashboard")
    public String home() {
        return "/user/index";
    }

    @GetMapping("/user/confirmed")
    public String confirmed() {
        return "/user/konfirmasi";
    }

    @Autowired
    private LoanService loanService;

    @PostMapping("/user/dashboard/new")
    public String createNewLoan(
            @RequestParam String nama,
            @RequestParam String no_telpon,
            @RequestParam String alamat,
            @RequestParam String email,
            @RequestParam BigDecimal jumlah_pinjaman,
            @RequestParam int lama_pinjaman,
            @RequestParam String nama_bank,
            @RequestParam String nomor_rekening
    ) {
        // Buat objek Loan baru dan set nilai-nilai yang diberikan dari request
        Loan newLoan = new Loan();
        newLoan.setNama(nama);
        newLoan.setNoTelpon(no_telpon);
        newLoan.setAlamat(alamat);
        newLoan.setEmail(email);
        newLoan.setJumlahPinjaman(jumlah_pinjaman);
        newLoan.setLamaPinjaman(lama_pinjaman);
        newLoan.setNamaBank(nama_bank);
        newLoan.setNomorRekening(nomor_rekening);
        newLoan.setStatus(Loan.Status.pending); // Set status default sebagai PENDING

        // Simpan loan baru ke database
        loanService.saveLoan(newLoan);

        return "redirect:/user/confirmed";
    }

}
