package com.greensuper.GreenSuper.services.admin.category;

import com.greensuper.GreenSuper.dto.CategoryDto;
import com.greensuper.GreenSuper.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);


    List<Category> getAllCategories();
}
