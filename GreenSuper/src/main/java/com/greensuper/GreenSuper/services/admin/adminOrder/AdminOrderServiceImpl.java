package com.greensuper.GreenSuper.services.admin.adminOrder;


import com.greensuper.GreenSuper.dto.OrderDto;
import com.greensuper.GreenSuper.entity.Order;
import com.greensuper.GreenSuper.enums.OrderStatus;
import com.greensuper.GreenSuper.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {
    private final OrderRepository orderRepository;

    public List<OrderDto> getAllPlacedOrders() {

        List<Order> orderList = orderRepository.findAllByOrderStatusIn(List.of(OrderStatus.Placed, OrderStatus.Shipped, OrderStatus.Delivered));

        return orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());


    }

    public OrderDto changeOrderStatus(Long orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            if (Objects.equals(status, "shipped")) {
                order.setOrderStatus(OrderStatus.Shipped);

            } else if (Objects.equals(status, "delivered")) {
                order.setOrderStatus(OrderStatus.Delivered);

            }
            return orderRepository.save(order).getOrderDto();
        }
    return null;
}

}
