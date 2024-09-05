package io.vladimirdev.firstmodule.services;

import io.vladimirdev.firstmodule.entities.Product;
import io.vladimirdev.firstmodule.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class ProductService {
private final ProductRepo productRepo;

public List<Product> getAllProducts() {
    return productRepo.findAll();
}
}
