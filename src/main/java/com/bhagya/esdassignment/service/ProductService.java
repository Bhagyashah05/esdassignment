package com.bhagya.esdassignment.service;

import com.bhagya.esdassignment.dto.CustomerRequest;
import com.bhagya.esdassignment.dto.ProductReq;
import com.bhagya.esdassignment.entity.Customer;
import com.bhagya.esdassignment.entity.product;
import com.bhagya.esdassignment.mapper.CustomerMapper;
import com.bhagya.esdassignment.mapper.ProductMapper;
import com.bhagya.esdassignment.repo.ProductRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepo productrepo;
    private final ProductMapper productMapper;

    public List<product> getTop2ProductsByPriceRange() {
        return productrepo.findTop2ProductsByPriceRange();
    }


    public String createProduct(ProductReq request) {
        product product = productMapper.toproduct(request);
        productrepo.save(product);
        return "product Created Successfully";
    }

    public List<?> getProduct() {
        return productrepo.findAll();
    }
}
