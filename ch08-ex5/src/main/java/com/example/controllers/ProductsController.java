package com.example.controllers;

import com.example.model.Product;
import com.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/products")
    @RequestMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

//    @PostMapping("/products")
//    @RequestMapping(path = "/products", method = RequestMethod.POST)
//    public String addProduct(
//            @RequestParam String name,
//            @RequestParam double price,
//            Model model) {
//        Product p = new Product();
//        p.setName(name);
//        p.setPrice(price);
//        productService.addProduct(p);
//
//        var products = productService.findAll();
//        model.addAttribute("products", products);
//
//        return "products.html";
//    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
