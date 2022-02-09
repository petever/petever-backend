package com.example.petever.account.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEditDto {
    private Integer id;
    private String registrant;
    private String name;
    private Integer parent_id;
}
