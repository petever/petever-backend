package com.example.petever.account.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAddDto {
    private String registrant;
    private String name;
    private long parent_id;
}
