package com.greensuper.GreenSuper.controller.admin;


import com.greensuper.GreenSuper.dto.ProductDto;
import com.greensuper.GreenSuper.services.admin.adminproduct.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/product")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1 = adminProductService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List <ProductDto> productDtos = adminProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductsByName(@PathVariable String name) {
        List <ProductDto> productDtos = adminProductService.getAllProductsByName(name);
        return ResponseEntity.ok(productDtos);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long prodouctId){
        boolean deleted = adminProductService.deleteProduct(prodouctId);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
        ProductDto productDto = adminProductService.getProductById(productId);
        if (productDto !=null){
            return ResponseEntity.ok(productDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/product/{productId}")
    public  ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId,@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto updateProduct = adminProductService.updateProduct(productId,productDto);
        if (updateProduct !=null){
            return ResponseEntity.ok(productDto);
        }else {
            return ResponseEntity.notFound().build();
        }

    }





}
