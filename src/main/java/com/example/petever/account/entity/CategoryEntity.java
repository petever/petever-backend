package com.example.petever.account.entity;


import com.example.petever.account.dto.category.CategoryEditDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryEntity extends BaseTimeEntity {
    @Id @GeneratedValue
    private Integer id;
    private String registrant;
    private String name;
    private Integer parent_id;
    private Integer category_order;


    public void changeCategoryName(String name) {
        this.name = name;
    }
}
