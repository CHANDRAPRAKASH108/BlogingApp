package com.application.BlogingApp.Service;

import com.application.BlogingApp.Payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create category
    CategoryDto createCategory(CategoryDto categoryDto);

    //update category
    CategoryDto updateCategory(CategoryDto categoryDto,Integer category_id);

    //get one category
    CategoryDto getCategoryById(Integer category_id);

    //get all category
    List<CategoryDto> getAllCategory();

    //delete category
    void deleteCategory(Integer category_id);
}
