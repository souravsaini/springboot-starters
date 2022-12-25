package com.sourav.blogapp.services;

import com.sourav.blogapp.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long id);

    boolean deleteCategory(Long id);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategory(Long id);
}
