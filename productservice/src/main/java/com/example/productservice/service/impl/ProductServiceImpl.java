/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.example.productservice.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import org.springframework.stereotype.Service;

import com.example.productservice.entity.Product;
import com.example.productservice.exception.ProductServiceCustomException;
import com.example.productservice.payload.request.ProductRequest;
import com.example.productservice.payload.response.ProductResponse;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author kamlesh
 *
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public long addProduct(final ProductRequest productRequest) {
		log.info("ProductServiceImpl | addProduct is called");

		Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
				.price(productRequest.getPrice()).build();

		product = productRepository.save(product);

		log.info("ProductServiceImpl | addProduct | Product Created");
		log.info("ProductServiceImpl | addProduct | Product Id : " + product.getProductId());
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(final long productId) {

		log.info("ProductServiceImpl | getProductById is called");
		log.info("ProductServiceImpl | getProductById | Get the product for productId: {}", productId);

		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		ProductResponse productResponse = new ProductResponse();

		copyProperties(product, productResponse);

		log.info("ProductServiceImpl | getProductById | productResponse :" + productResponse.toString());

		return productResponse;
	}

	@Override
	public void reduceQuantity(final long productId, final long quantity) {

		log.info("Reduce Quantity {} for Id: {}", quantity, productId);

		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("Product does not have sufficient Quantity",
					"INSUFFICIENT_QUANTITY");
		}

		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);
		log.info("Product Quantity updated Successfully");
	}

	@Override
	public void deleteProductById(final long productId) {
		log.info("Product id: {}", productId);

		if (!productRepository.existsById(productId)) {
			log.info("Im in this loop {}", !productRepository.existsById(productId));
			throw new ProductServiceCustomException("Product with given with Id: " + productId + " not found:",
					"PRODUCT_NOT_FOUND");
		}
		log.info("Deleting Product with id: {}", productId);
		productRepository.deleteById(productId);

	}
}