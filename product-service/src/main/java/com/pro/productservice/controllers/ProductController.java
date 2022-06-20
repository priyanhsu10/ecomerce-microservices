package com.pro.productservice.controllers;

import com.pro.productservice.dto.ProductRequest;
import com.pro.productservice.dto.ProductResponse;
import com.pro.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(){

        return  ResponseEntity.ok(productService.getAllProducts());
    }
}
