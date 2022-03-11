package com.example.BikersBackend.repositories;

import com.example.BikersBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
