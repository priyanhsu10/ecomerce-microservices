package com.pro.productservice.services;

import com.pro.productservice.dto.ProductRequest;
import com.pro.productservice.dto.ProductResponse;
import com.pro.productservice.entities.Product;
import com.pro.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;

    public ProductResponse createProduct(ProductRequest product) {
        Product p = Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
        repository.save(p);
        log.info("product {} created", p.getId());
        return ProductResponse.builder().description(p.getDescription()).price(p.getPrice())
                .name(p.getName()).id(p.getId()).build();
    }

    public List<ProductResponse> getAllProducts() {
        return repository.findAll().stream().map(x -> maptoResponse(x)).collect(Collectors.toList());
    }

    private ProductResponse maptoResponse(Product p) {

        return ProductResponse.builder().description(p.getDescription()).price(p.getPrice())
                .name(p.getName()).id(p.getId()).build();
    }
}
