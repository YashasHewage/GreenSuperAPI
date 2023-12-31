package com.greensuper.GreenSuper.services.customer.review;

import com.greensuper.GreenSuper.dto.OrderedProductsResponseDto;
import com.greensuper.GreenSuper.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {

    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview (ReviewDto reviewDto) throws IOException;

}
