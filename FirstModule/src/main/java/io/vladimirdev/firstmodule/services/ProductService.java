package io.vladimirdev.firstmodule.services;

import dtos.ProductDto;
import io.vladimirdev.firstmodule.entities.Product;
import io.vladimirdev.firstmodule.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class ProductService {
private final ProductRepo productRepo;

public Product getProductById(int id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
public List<Product> getAllProducts() {
    return productRepo.findAll();
}

    public void save(ProductDto product) {
    productRepo.save(Product.builder().title(product.getTitle()).details(product.getDetails()).build());
}

    public void update(Product product) {
    productRepo.save(Product.builder().id(product.getId()).title(product.getTitle()).details(product.getDetails()).build());
    }

    public void delete(Product product) {
    productRepo.delete(product);
    }
}
