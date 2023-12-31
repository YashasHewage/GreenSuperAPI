package com.greensuper.GreenSuper.entity;

import com.greensuper.GreenSuper.dto.OrderDto;
import com.greensuper.GreenSuper.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "orders")
@Entity
@Data
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderDescription;

    private Long amount;

    private String address;

    private String payment;

    private OrderStatus orderStatus;

    private Long totalAmount;

    private Long discount;

    private UUID trackingId;

    private Date date;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItems> cartItems;

    public  OrderDto getOrderDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderDescription(orderDescription);
        orderDto.setAmount(amount);
        orderDto.setAddress(address);
        orderDto.setPayment(payment);
        orderDto.setOrderStatus(orderStatus);
        orderDto.setTotalAmount(totalAmount);
        orderDto.setDiscount(discount);
        orderDto.setTrackingId(trackingId);






        return orderDto;
    }



}
