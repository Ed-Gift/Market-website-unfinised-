package com.marketplace.CONTROLLERS;

import com.marketplace.model.Product;
import com.marketplace.SERVICES.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        if(!product.getSeller().isApproved()){
            throw new RuntimeException("Seller not approved yet");
        }
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();

    }
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws Exception {

        String path = "uploads/" + file.getOriginalFilename();
        file.transferTo(new java.io.File(path));

        return path;
    }
}