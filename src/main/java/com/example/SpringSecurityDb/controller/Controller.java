package com.example.SpringSecurityDb.controller;

import com.example.SpringSecurityDb.entity.Product;
import com.example.SpringSecurityDb.entity.User;
import com.example.SpringSecurityDb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ProductService service;
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
    @PostMapping("/new")
    //@PreAuthorize("hasAuthority('ROLE_user')")
    public String addNewUser(@RequestBody User user) {
        return service.addUser(user);
    }
    @GetMapping("/all")
    //  @PreAuthorize("hasAuthority('ROLE_admin')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }
    @GetMapping("/{id}")
    //@PreAuthorize("hasAuthority('ROLE_user')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
    @DeleteMapping("/del")
    public User deleteProduct(@RequestBody User user) {
        return service.deleteUser(user);
    }
    @PutMapping("/upd")
    public  User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
}
