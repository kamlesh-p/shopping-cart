/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.example.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.entity.Product;

/**
 * @author kamlesh
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
