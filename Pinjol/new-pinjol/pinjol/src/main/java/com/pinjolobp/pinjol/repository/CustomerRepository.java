package com.pinjolobp.pinjol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinjolobp.pinjol.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}