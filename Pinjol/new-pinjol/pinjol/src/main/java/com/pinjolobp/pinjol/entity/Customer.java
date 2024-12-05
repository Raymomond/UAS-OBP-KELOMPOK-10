package com.pinjolobp.pinjol.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "customers")
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Kolom id auto increment di tabel customers
    private Long id;

    @Override
    public String getSpecificId() {
        // Mengembalikan id dari tabel customers jika role adalah USER
        return this.getRole() == Role.USER ? String.valueOf(this.getId()) : null;
    }
}
