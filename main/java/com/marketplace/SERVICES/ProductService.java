package com.marketplace.SERVICES;

import com.marketplace.model.Product;
import com.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.marketplace.service.ActivityLogService;

import java.util.List;

@Service
public class ProductService {
    private final ActivityLogService logService;

    private final ProductRepository repo;

    public ProductService(ProductRepository repo,
                          ActivityLogService logService) {

        this.repo = repo;
        this.logService = logService;
    }

    Product saved = repo.save(product);

if(saved.getSeller() != null){
        logService.log(
                saved.getSeller().getId(),
                "Added product: " + saved.getName()
        );
    }

return saved;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}