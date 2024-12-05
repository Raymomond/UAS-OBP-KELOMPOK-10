package com.pinjolobp.pinjol.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nama;

    @Column(name = "no_telpon", nullable = false)
    private String noTelpon;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String alamat;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "jumlah_pinjaman", nullable = false, precision = 15, scale = 2)
    private BigDecimal jumlahPinjaman;

    @Column(name = "lama_pinjaman", nullable = false)
    private Integer lamaPinjaman;

    @Column(name = "nama_bank", nullable = false)
    private String namaBank;

    @Column(name = "nomor_rekening", nullable = false, unique = true)
    private String nomorRekening;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public enum Status {
        approved,
        pending,
        rejected
    }

    public String getStatus() {
        return status.name();  // Mengembalikan status sebagai String
    }


}