package com.example.demo;

import com.azure.data.cosmos.internal.http.HttpResponse;
import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Function<Product, String> createProduct() {
		return product -> {
			productRepository.save(product);
			return "Saved Product";
		};
	}

	@Bean
	public Function<Product, String> deleteProduct() {
		return product -> {
			Product p = productRepository.findById(product.getProductId()).orElse(null);

			if (p != null) {
				productRepository.delete(p);
				return "Deleted product";
			} else {
				return "Failed to delete product";
			}
		};
	}

}
