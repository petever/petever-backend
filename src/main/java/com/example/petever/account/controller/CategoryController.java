package com.example.petever.account.controller;

import com.example.petever.account.dto.category.CategoryAddDto;
import com.example.petever.account.dto.category.CategoryEditDto;
import com.example.petever.account.dto.category.CategoryOrderDto;
import com.example.petever.account.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public void getCategory(@RequestParam("email") String email) {
        categoryService.getCategory(email);
    }

    @PostMapping
    public void addCategory(@RequestBody CategoryAddDto categoryAddDto) {
        categoryService.addCategory(categoryAddDto);
    }

    @PatchMapping
    public void editCategory(@RequestBody CategoryEditDto categoryEditDto) {
        categoryService.editCategory(categoryEditDto);
    }

    @DeleteMapping
    public void deleteCategory() {
        categoryService.deleteCategory();
    }

    @PatchMapping("/order")
    public void changeCategoryOrder(@RequestBody CategoryOrderDto categoryOrderDto) {
        categoryService.changeCategoryOrder(categoryOrderDto);
    }


}
