package com.greensuper.GreenSuper.services.customer;

import com.greensuper.GreenSuper.dto.ProductDetailDto;
import com.greensuper.GreenSuper.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {
    List<ProductDto>searchProductByTitle(String title);

    List<ProductDto> getAllProducts();

    ProductDetailDto getProductDetailedById(Long productId);
}
