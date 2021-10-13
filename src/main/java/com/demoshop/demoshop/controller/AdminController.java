package com.demoshop.demoshop.controller;

import com.demoshop.demoshop.model.Product;
import com.demoshop.demoshop.model.ProductType;
import com.demoshop.demoshop.repository.ProductRepository;
import com.demoshop.demoshop.repository.ProductTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    ProductTypeRepository productTypeRepository;
    ProductRepository productRepository;

    public AdminController(ProductTypeRepository productTypeRepository, ProductRepository productRepository) {
        this.productTypeRepository = productTypeRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public String admin(Model model) {
        Iterable<ProductType> types = productTypeRepository.findAll();
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("productTypes", types);
        model.addAttribute("products", products);
        return "/admin/admin-index";
    }

    @GetMapping("/docs")
    public String docs(Model model) {
        return "/admin/docs";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        return "/admin/orders";
    }
}
