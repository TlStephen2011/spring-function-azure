package com.example.demo.domain;

import com.azure.data.cosmos.PartitionKey;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@ToString
@Document(collection = "products")
public class Product {

    @Id
    @Generated
    private String productId;

    private String productName;

    private double price;

    @com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey
    private String category;

    public Product(String productName, double price, String category) {
        this.productId = UUID.randomUUID().toString();
        this.productName = productName;
        this.price = price;
        this.category = new PartitionKey(category).toString();
    }

    public Product() {
        this.productId = UUID.randomUUID().toString();
    }

    public Product(String id) {
        this.productId = id;
    }

}
