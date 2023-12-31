package com.greensuper.GreenSuper.dto;



import com.greensuper.GreenSuper.enums.OrderStatus;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {

    private long id;

    private String orderDescription;

    private Long amount;

    private String address;

    private String payment;

    private OrderStatus orderStatus;

    private Long totalAmount;

    private Long discount;

    private UUID trackingId;


    private String userName;


    private List<CartItemsDto> cartItems;
}
