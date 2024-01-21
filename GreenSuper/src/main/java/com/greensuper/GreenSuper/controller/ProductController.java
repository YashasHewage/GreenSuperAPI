package com.greensuper.GreenSuper.controller;


import com.greensuper.GreenSuper.dto.ProductDto;

import com.greensuper.GreenSuper.services.admin.adminproduct.AdminProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class ProductController {


    @Autowired
    private AdminProductServiceImpl adminProductServiceImpl;

    /*   @PreAuthorize("hasRole('ADMIN')")*/
    @PostMapping("/productAdd")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        ProductDto createProduct = adminProductServiceImpl.addProduct(product);
        return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED);
    }

    //view Product
    @GetMapping("/view")
    public ResponseEntity<List<ProductDto>>viewAllProduct(){
        List<ProductDto> viewAll = adminProductServiceImpl.viewAll();
        return new ResponseEntity<List<ProductDto>>(viewAll,HttpStatus.ACCEPTED);
    }

    @GetMapping("/view/{productId}")
    public ResponseEntity<ProductDto> viewProductById(@PathVariable int productId) {

        ProductDto viewById = adminProductServiceImpl.viewProductById(productId);
        return new ResponseEntity<ProductDto>(viewById, HttpStatus.OK);
    }

    //Delete product
        @DeleteMapping("/del/{productId}")
        public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
            adminProductServiceImpl.deleteProduct(productId);
            return new ResponseEntity <String>("Product Deleted", HttpStatus.OK);
        }

    //Update Product
    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int productId,@RequestBody ProductDto newProduct){
        ProductDto updateProduct = adminProductServiceImpl.updateProduct(productId,newProduct);
        return new ResponseEntity<ProductDto>(updateProduct,HttpStatus.ACCEPTED);
    }



}