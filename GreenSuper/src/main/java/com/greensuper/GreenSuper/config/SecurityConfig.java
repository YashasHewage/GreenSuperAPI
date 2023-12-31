package com.greensuper.GreenSuper.config;

import com.greensuper.GreenSuper.dto.ProductDetailDto;
import com.greensuper.GreenSuper.dto.ProductDto;
import com.greensuper.GreenSuper.services.customer.CustomerProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoderBean(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(){
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return null;
            }
        };
    }
    @Bean
    public CustomerProductService customerProductService(){
        return new CustomerProductService() {
            @Override
            public List<ProductDto> searchProductByTitle(String title) {
                return null;
            }

            @Override
            public List<ProductDto> getAllProducts() {
                return null;
            }

            @Override
            public ProductDetailDto getProductDetailedById(Long productId) {
                return null;
            }
        };
    }

}
