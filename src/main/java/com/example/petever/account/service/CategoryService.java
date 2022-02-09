package com.example.petever.account.service;

import com.example.petever.account.dto.category.CategoryAddDto;
import com.example.petever.account.entity.CategoryEntity;
import com.example.petever.account.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public void getCategory(String email) {
        categoryRepository.findByRegistrant(email);
    }

    public void addCategory(CategoryAddDto categoryAddDto) {
        CategoryEntity category = modelMapper.map(categoryAddDto, CategoryEntity.class);
        categoryRepository.save(category);
    }

    public void editCategory() {
    }

    public void deleteCategory() {
    }

    public void changeCategoryOrder() {
    }

}
