package com.greensuper.GreenSuper.services.admin.adminOrder;

import com.greensuper.GreenSuper.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {

    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);
}
