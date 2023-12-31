package com.greensuper.GreenSuper.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderedProductsResponseDto {

    private List<ProductDto> productDtosList;

    private Long orderAmount;
}
