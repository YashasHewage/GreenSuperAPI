package com.greensuper.GreenSuper.repository;

import com.greensuper.GreenSuper.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    //public Product findById(int product);

    /*List<Product> findAllByNameContaining(String title);*/
}
