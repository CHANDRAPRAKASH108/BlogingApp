package com.application.BlogingApp.Controller;

import com.application.BlogingApp.Payloads.ApiResponse;
import com.application.BlogingApp.Payloads.CategoryDto;
import com.application.BlogingApp.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //create

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1= this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{category_id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer category_id){
        CategoryDto categoryDto1 = this.categoryService.updateCategory(categoryDto,category_id);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }

    //get
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDtoList = this.categoryService.getAllCategory();
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    //get by id
    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer category_id){
        CategoryDto categoryDto = this.categoryService.getCategoryById(category_id);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{category_id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer category_id){
        this.categoryService.deleteCategory(category_id);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully",true), HttpStatus.OK);
    }
}
