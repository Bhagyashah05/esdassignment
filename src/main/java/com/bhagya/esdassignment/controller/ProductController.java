package com.bhagya.esdassignment.controller;

import com.bhagya.esdassignment.dto.ProductReq;
import com.bhagya.esdassignment.entity.product;
import com.bhagya.esdassignment.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/top2byprice")
    public List<product> getTop2ProductsByPriceRange() {
        return productService.getTop2ProductsByPriceRange();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductReq request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<?>> getProduct() {
        return ResponseEntity.ok(productService.getProduct());
    }
}
