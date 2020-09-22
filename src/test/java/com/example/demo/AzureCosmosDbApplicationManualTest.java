package com.example.demo;

import com.azure.data.cosmos.PartitionKey;
import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class AzureCosmosDbApplicationManualTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void givenProductIsCreated_whenCallFindById_thenProductIsFound() {
		Product product = new Product();
		product.setPrice(110.0);
		product.setProductName("Blue Shirt");
		product.setCategory("Shirt");

		productRepository.save(product);
		Product retrievedProduct = productRepository.findById(product.getProductId())
				.orElse(null);
		Assert.notNull(retrievedProduct, "Retrieved Product is Null");
	}

}
