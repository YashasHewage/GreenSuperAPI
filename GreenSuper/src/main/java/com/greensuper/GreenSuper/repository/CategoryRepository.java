package com.greensuper.GreenSuper.repository;

import com.greensuper.GreenSuper.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //public Product findById(int product);

    /*List<Product> findAllByNameContaining(String title);*/
}
