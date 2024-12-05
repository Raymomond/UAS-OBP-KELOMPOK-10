package com.pinjolobp.pinjol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinjolobp.pinjol.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
