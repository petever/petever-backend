package com.example.petever.account.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String registrant;
    private String name;
    private Integer parent_id;
    private Integer order;
}
