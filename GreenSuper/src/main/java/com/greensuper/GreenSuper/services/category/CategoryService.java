package com.greensuper.GreenSuper.services.category;

import com.greensuper.GreenSuper.dto.CategoryDto;
import com.greensuper.GreenSuper.entity.Category;
import com.greensuper.GreenSuper.exception.ResourceNotFoundException;
import com.greensuper.GreenSuper.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;

    public CategoryDto create (CategoryDto dto){
        Category category = this.mapper.map(dto, Category.class);
        Category save = this.categoryRepository.save(category);


        return this.mapper.map(save, CategoryDto.class);
    }


    public CategoryDto update (CategoryDto newcategory,int categoryId){
        Category oldCategory =this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found"));

        oldCategory.setTitle(newcategory.getTitle());
        Category save = this.categoryRepository.save(oldCategory);
        return this.mapper.map(save,CategoryDto.class);
    }

    public void delete (int categoryID){
        Category Category =this.categoryRepository.findById(categoryID).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
        this.categoryRepository.delete(Category);
    }
    public CategoryDto getbyId(int categoryId){
        Category getById = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
        return this.mapper.map(getById,CategoryDto.class);
    }
    public List<CategoryDto> getAll(){
        List<Category> findAll = this.categoryRepository.findAll();
        List<CategoryDto> allDto = findAll.stream().map(category -> this.mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return allDto;

    }
}
