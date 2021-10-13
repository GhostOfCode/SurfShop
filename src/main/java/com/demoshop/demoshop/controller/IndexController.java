package com.demoshop.demoshop.controller;

import com.demoshop.demoshop.model.Product;
import com.demoshop.demoshop.model.ProductType;
import com.demoshop.demoshop.repository.ProductRepository;
import com.demoshop.demoshop.repository.ProductTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class IndexController {

    ProductTypeRepository productTypeRepository;
    ProductRepository productRepository;

    public IndexController(ProductTypeRepository productTypeRepository, ProductRepository productRepository) {
        this.productTypeRepository = productTypeRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        Iterable<ProductType> types = productTypeRepository.findAll();
        Map<ProductType, List<Product>> map = new HashMap<>(); //Мапа ТипПродукта и Список продуктов по типу(ключу)
        types.forEach(type -> map.put(type, productRepository.findByProductType(type))); //закидываем в мапу для каждого типа продукт
        model.addAttribute("map", map);
        return "index";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") Long id, Model model){
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "product";
    }

}
