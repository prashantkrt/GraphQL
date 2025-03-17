package com.mylearning.springbootgraphql.controller;

import com.mylearning.springbootgraphql.entity.Product;
import com.mylearning.springbootgraphql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductGraphQLController {

    private final ProductService productService;

    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product getProductById(@Argument Integer id) {
        return productService.getProductById(id);
    }

    @QueryMapping
    public ResponseEntity<List<Product>> getProductsByCategory(@Argument String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @QueryMapping
    public List<Product> getProductByPriceRange(@Argument Double minPrice, @Argument Double maxPrice) {
        return productService.getProductByPriceRange(minPrice, maxPrice);
    }
}
