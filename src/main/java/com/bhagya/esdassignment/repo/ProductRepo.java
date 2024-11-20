package com.bhagya.esdassignment.repo;

import com.bhagya.esdassignment.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<product,Long> {
    @Query("SELECT p FROM product p WHERE p.price BETWEEN  15 AND 30 ORDER BY p.price ASC")
    List<product> findTop2ProductsByPriceRange();
}
