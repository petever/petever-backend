package com.example.petever.account.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long id;
    private String registrant;
    private String name;
    private long parent_id;
    private int order;
}
