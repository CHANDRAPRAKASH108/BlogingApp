package com.application.BlogingApp.ServiceImplementation;

import com.application.BlogingApp.Entity.Category;
import com.application.BlogingApp.Exceptions.ResourceNotFoundException;
import com.application.BlogingApp.Payloads.CategoryDto;
import com.application.BlogingApp.Repositories.CategoryRepository;
import com.application.BlogingApp.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryImplementation implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto,Category.class);
        Category addCategory = this.categoryRepository.save(category);
        return this.modelMapper.map(addCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer category_id) {
        Category category = this.categoryRepository.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category","Id ",category_id));
        category.setCategory_title(categoryDto.getCategory_title());
        category.setCategory_description(categoryDto.getCategory_description());
        Category updateCategory = this.categoryRepository.save(category);
        return this.modelMapper.map(updateCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer category_id) {
        Category category = this.categoryRepository.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category","Id ",category_id));
        return this.modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(category -> this.modelMapper.map(category,CategoryDto.class)).toList();
    }

    @Override
    public void deleteCategory(Integer category_id) {
        Category category = this.categoryRepository.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category","Id ",category_id));
        this.categoryRepository.delete(category);
    }
}
