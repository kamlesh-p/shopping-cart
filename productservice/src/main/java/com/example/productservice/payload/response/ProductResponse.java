/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.example.productservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kamlesh
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private String productName;
	private long productId;
	private long quantity;
	private long price;
}
