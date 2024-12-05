package com.pinjolobp.pinjol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.pinjolobp.pinjol")
public class PinjolApplication {
    public static void main(String[] args) {
        SpringApplication.run(PinjolApplication.class, args);
    }

	@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
}
