package com.greensuper.GreenSuper.repository;

import com.greensuper.GreenSuper.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

    Optional <CartItems> findByProductIdAndOrderIdAndUserId(Long productId, Long orderId, Long userId);

}
