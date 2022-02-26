package com.example.petever.account.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryOrderDto {
    private Integer id;
    private Integer parent_id;
    private Integer order;
}
