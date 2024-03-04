package com.example.SpringSecurityDb.service;

import com.example.SpringSecurityDb.entity.Product;
import com.example.SpringSecurityDb.entity.User;
import com.example.SpringSecurityDb.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }

    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return "user addeed";
    }

    public User deleteUser(User user){
        User u = repository.findById(user.getId()).orElseThrow();
        System.out.println("hi");
        repository.delete(u);
        return user;
    }
    @Modifying
    public User updateUser(User user){
       if(repository.existsById(user.getId())){
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           repository.save(user);
           return user;
       }
       return null;
    }
}
