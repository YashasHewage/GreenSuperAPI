package com.greensuper.GreenSuper.services.auth;

import com.greensuper.GreenSuper.dto.SingupRequest;
import com.greensuper.GreenSuper.dto.UserDto;
import com.greensuper.GreenSuper.entity.Order;
import com.greensuper.GreenSuper.entity.User;
import com.greensuper.GreenSuper.enums.OrderStatus;
import com.greensuper.GreenSuper.enums.UserRole;
import com.greensuper.GreenSuper.repository.OrderRepository;
import com.greensuper.GreenSuper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private OrderRepository orderRepository;

    public UserDto createUser(SingupRequest signupRequest){
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);

        Order order = new Order();
        order.setAmount(0L);
        order.setTotalAmount(0L);
        order.setDiscount(0L);
        order.setUser(createdUser);
        order.setOrderStatus(OrderStatus.Pending);
        orderRepository.save(order);


        UserDto userDto = new UserDto();
        userDto.setEmail(createdUser.getEmail());

        return userDto;
    }

    public  Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }

}

