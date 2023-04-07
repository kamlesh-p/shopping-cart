/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.example.productservice.payload.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author kamlesh
 *
 */
@Data
@Builder
public class ProductRequest {
	private String name;
	private long price;
	private long quantity;
}
