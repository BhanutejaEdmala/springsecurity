package com.example.SpringSecurityDb;

import com.example.SpringSecurityDb.entity.User;
import com.example.SpringSecurityDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDbApplication implements CommandLineRunner {
@Autowired
	UserRepository urepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User user = urepo.findById(1).get();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.matches("user","$2a$10$btkcSx75wr1HJAd6y044JuFiO.rcRyG7mSWSQarKeCDdn6hOfgt7u"));
	}
}
