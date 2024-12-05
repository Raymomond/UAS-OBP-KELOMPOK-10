package com.pinjolobp.pinjol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.pinjolobp.pinjol.entity.User;
import com.pinjolobp.pinjol.entity.User.Role;
import com.pinjolobp.pinjol.repository.UserRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
// localhost:8081/auth/login

@PostMapping("/login")
public void login(@RequestParam String username, @RequestParam String password, HttpSession session, HttpServletResponse response) throws IOException {
    // Mencari user berdasarkan username
    Optional<User> optionalUser = userRepository.findByUsername(username);

    // Cek jika username tidak ditemukan
    if (optionalUser.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Username tidak ada!");
        return;
    }
    
    User user = optionalUser.get();

    // Membandingkan password yang dimasukkan dengan password yang terenkripsi
    if (passwordEncoder.matches(password, user.getPassword())) {
        session.setAttribute("user", user);

        // Redirect berdasarkan role
        if (Role.USER.equals(user.getRole())) {
            response.sendRedirect("/user/dashboard"); // Redirect untuk role USER
        } else if (Role.ADMIN.equals(user.getRole())) {
            response.sendRedirect("/"); // Redirect untuk role ADMIN
        } else {
            response.sendRedirect("/"); // Redirect default
        }

    } else {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Password salah!");
    }
}

@PostMapping("/loginadmin")
public void loginAdmin(@RequestParam String username, @RequestParam String password, HttpSession session, HttpServletResponse response) throws IOException {
    Optional<User> optionalUser = userRepository.findByUsername(username);

    // Cek jika username tidak ditemukan
    if (optionalUser.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Username tidak ada!");
        return;
    }
    
    User user = optionalUser.get();

    // Membandingkan password yang dimasukkan dengan password yang terenkripsi
    if (passwordEncoder.matches(password, user.getPassword())) {
        session.setAttribute("user", user);

        // Redirect berdasarkan role
        if (Role.USER.equals(user.getRole())) {
            response.sendRedirect("/"); // Redirect untuk role USER
        } else if (Role.ADMIN.equals(user.getRole())) {
            response.sendRedirect("/admin/dashboard"); // Redirect untuk role ADMIN
        } else {
            response.sendRedirect("/"); // Redirect default
        }

    } else {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Password salah!");
    }
}

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Hapus session
        return "Logout berhasil!";
    }
}
