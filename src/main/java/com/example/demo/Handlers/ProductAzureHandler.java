package com.example.demo.Handlers;

import com.example.demo.domain.Product;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class ProductAzureHandler extends AzureSpringBootRequestHandler<Product, String> {

    @FunctionName("createProduct")
    public HttpResponseMessage create(
            @HttpTrigger(name = "request", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Product>> request,
            ExecutionContext context) {

        context.getLogger().info("Adding product name: " + request.getBody().get().toString());
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(request.getBody().get(), context))
                .header("Content-Type", "application/json")
                .build();
    }

    @FunctionName("deleteProduct")
    public HttpResponseMessage remove(
            @HttpTrigger(name = "deleteRequest", methods = {HttpMethod.DELETE}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {

        String id = request.getQueryParameters().get("id");
        context.getLogger().info("Deleting product with id: " + id);

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(new Product(id), context))
                .header("Content-Type", "application/json")
                .build();
    }

}
