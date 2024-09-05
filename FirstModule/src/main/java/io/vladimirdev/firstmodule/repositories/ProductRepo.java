package io.vladimirdev.firstmodule.repositories;

import io.vladimirdev.firstmodule.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
public List<Product> findAll();

}
