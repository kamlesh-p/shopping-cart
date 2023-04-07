/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.example.productservice.service;

import com.example.productservice.payload.request.ProductRequest;
import com.example.productservice.payload.response.ProductResponse;

/**
 * @author kamlesh
 *
 */
public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceQuantity(long productId, long quantity);

	public void deleteProductById(long productId);
}
