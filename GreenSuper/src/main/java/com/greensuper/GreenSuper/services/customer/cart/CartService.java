package com.greensuper.GreenSuper.services.customer.cart;

import com.greensuper.GreenSuper.dto.AddProductInCartDto;
import com.greensuper.GreenSuper.dto.OrderDto;
import com.greensuper.GreenSuper.dto.PlaceOrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto  increaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto  decreaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto> getMyPlacedOrders(Long userId);
}