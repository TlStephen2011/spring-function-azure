package com.example.demo.repository;

import com.example.demo.domain.Product;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
}