package com.pinjolobp.pinjol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pinjolobp.pinjol.entity.Customer;
import com.pinjolobp.pinjol.entity.User;
import com.pinjolobp.pinjol.repository.CustomerRepository;
import com.pinjolobp.pinjol.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void saveCustomer(Customer customer) {
        // Mengenkripsi password customer sebelum disimpan
        String encryptedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);
    
        // Set default role jika belum diatur
        if (customer.getRole() == null) {
            customer.setRole(User.Role.USER); // Role.USER adalah nilai default
        }
    
        // Simpan Customer ke dalam tabel users terlebih dahulu
        User savedUser = userRepository.save(customer); // Menyimpan entitas User (Customer) pertama kali
    
        // Simpan Customer ke dalam tabel customers dengan id yang diatur otomatis
        customerRepository.save(customer); // Menyimpan Customer ke dalam tabel customers
    }
    
    
    // Hapus user berdasarkan ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    // Ambil semua user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}