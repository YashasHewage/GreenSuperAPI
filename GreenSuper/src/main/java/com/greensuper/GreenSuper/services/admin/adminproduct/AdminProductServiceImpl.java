package com.greensuper.GreenSuper.services.admin.adminproduct;

import com.greensuper.GreenSuper.dto.ProductDto;
import com.greensuper.GreenSuper.entity.Product;

import com.greensuper.GreenSuper.exception.ResourceNotFoundException;
import com.greensuper.GreenSuper.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AdminProductServiceImpl /*implements  AdminProductService*/{




    @Autowired
    private ProductRepository productRepository;

    public ProductDto addProduct(ProductDto product){
        Product entity = toEntity(product);

       Product save =  productRepository.save(entity);

       ProductDto dto = toDto(save);
       return dto;


       //Product to ProductDto

    }

    public List<ProductDto>viewAll(){

        List<Product> findAll = productRepository.findAll();


        return findAll.stream().map(product -> this.toDto(product)).collect(Collectors.toList());


    }

    public ProductDto viewProductById(int pid) {

       Product findById = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("from this ProductId:" +pid+ " Product not found"));
       ProductDto dto = this.toDto(findById);
       return dto;
    }

    public void deleteProduct(int pid) {
        Product product = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("from this ProductId:" +pid+ " Product not found"));
        productRepository.deleteById(pid);


    }

    public ProductDto updateProduct (int pid,ProductDto newProduct) {
        Product oldProduct = productRepository.findById(pid).orElseThrow(()-> new ResourceNotFoundException(+pid+"Product not found"));

        oldProduct.setProductName(newProduct.getProductName());
        oldProduct.setLive(newProduct.isLive());
        oldProduct.setStock(newProduct.isStock());
        oldProduct.setProductPrize(newProduct.getProductPrize());
        oldProduct.setProductDesc(newProduct.getProductDesc());
        oldProduct.setProductQuantity(newProduct.getProductQuantity());
        oldProduct.setImageName(newProduct.getImageName());
        Product save = productRepository.save(oldProduct);
        ProductDto dto = toDto(save);
        return  dto;

    }

    //ProdcutDto to Product
    public Product toEntity(ProductDto pDto){
        Product p=new Product();
        p.setProductId(pDto.getProductId());
        p.setProductName(pDto.getProductName());
        p.setProductDesc(pDto.getProductDesc());
        p.setProductPrize(pDto.getProductPrize());
        p.setImageName(pDto.getImageName());
        p.setLive(pDto.isLive());
        p.setStock(p.isStock());
        return p;
    }

    //Product to productDto
    public ProductDto toDto(Product product){
        ProductDto pDto = new ProductDto();
        pDto.setProductId(product.getProductId());
        pDto.setImageName(product.getImageName());
        pDto.setProductName(product.getProductName());
        pDto.setProductDesc(product.getProductDesc());
        pDto.setLive(product.isLive());
        pDto.setStock(product.isStock());
        pDto.setProductPrize(product.getProductPrize());

        return pDto;

    }



/*    public ProductDto addProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        //product.setCategory(productDto.getCategory());
        return productRepository.save(product).getDto();

    }*/



 /*public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return  products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsByName(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return  products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProductDto getProductById(Long productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.map(Product::getDto).orElse(null);
    }

    public ProductDto updateProduct(Long productId, ProductDto productDto) {
      Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found" + productId));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        return  productRepository.save(product).getDto();


        }*/


    }



