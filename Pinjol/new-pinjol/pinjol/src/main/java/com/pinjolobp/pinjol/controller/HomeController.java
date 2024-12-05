package com.pinjolobp.pinjol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pinjolobp.pinjol.entity.Customer;
import com.pinjolobp.pinjol.service.UserService;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginadmin")
    public String loginAdmin() {
        return "login-admin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @Autowired
    private UserService userService;
    
    @PostMapping("/signup/new")
    public String addUser(@ModelAttribute Customer customer, Model model) {
        // Simpan customer baru
        userService.saveCustomer(customer);
    
        model.addAttribute("successMessage", "Pendaftaran berhasil! Silakan login.");
        return "redirect:/login"; 
    }
}