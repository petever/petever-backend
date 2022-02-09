package com.example.petever.account.controller;

import com.example.petever.account.dto.category.CategoryAddDto;
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
        System.out.println("categoryAddDto = " + categoryAddDto);
        categoryService.addCategory(categoryAddDto);
    }

    @PatchMapping
    public void editCategory() {
        categoryService.editCategory();
    }

    @DeleteMapping
    public void deleteCategory() {
        categoryService.deleteCategory();
    }

    @PatchMapping("/order")
    public void changeCategoryOrder() {
        categoryService.changeCategoryOrder();
    }


}
