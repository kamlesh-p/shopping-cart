/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.example.productservice.exception;

import lombok.Data;

/**
 * @author kamlesh
 *
 */
@Data
public class ProductServiceCustomException extends RuntimeException {

	private static final long serialVersionUID = -8149787554774318894L;
	private String errorCode;

	public ProductServiceCustomException(final String message, final String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
