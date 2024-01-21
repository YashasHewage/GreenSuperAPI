package com.greensuper.GreenSuper.controller;


import com.greensuper.GreenSuper.dto.ApiResponse;
import com.greensuper.GreenSuper.dto.CategoryDto;
import com.greensuper.GreenSuper.services.category.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    private CategoryDto create;


    @PostMapping("/create")
    public ResponseEntity<CategoryDto>create (@RequestBody CategoryDto categoryDto){
        CategoryDto create = this.categoryService.create(categoryDto);
        return new ResponseEntity<CategoryDto>(create, HttpStatus.ACCEPTED);
    }

    //UpdateCategory
    @PutMapping("/update/{categoryId}")
    public <categoryId> ResponseEntity<CategoryDto>update (@RequestBody CategoryDto categoryDto,@PathVariable int categoryId){
        System.out.println(categoryId);
        CategoryDto update = this.categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<CategoryDto>(update, HttpStatus.ACCEPTED);
    }

    //DeleteCategory
    @DeleteMapping("/delete/{catId}")
    public ResponseEntity<ApiResponse>delete (@PathVariable int catId){
      this.categoryService.delete(catId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted",true), HttpStatus.OK);
    }
    //GetCategoryById
    @GetMapping("/getbyId/{catId}")
    public ResponseEntity<CategoryDto>getbyId (@PathVariable int catId){
        CategoryDto getbyId = this.categoryService.getbyId(catId);
        return new ResponseEntity<CategoryDto>(getbyId, HttpStatus.ACCEPTED);
    }

    //GetAllCategory
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAll (){
        List<CategoryDto> all = this.categoryService.getAll();
        return new ResponseEntity<List<CategoryDto>>(all, HttpStatus.ACCEPTED);
    }




}
