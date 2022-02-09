package com.example.petever.account.entity;


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
    private long id;
    private String registrant;
    private String name;
    private long parent_id;
    private int order;
}
