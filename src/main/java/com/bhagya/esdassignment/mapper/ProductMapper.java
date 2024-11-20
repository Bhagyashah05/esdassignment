package com.bhagya.esdassignment.mapper;

import com.bhagya.esdassignment.dto.ProductReq;
import com.bhagya.esdassignment.entity.product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public product toproduct(ProductReq request) {
        return product.builder()
                .price(request.price())
                .name(request.name())
                .build();

    }
}
