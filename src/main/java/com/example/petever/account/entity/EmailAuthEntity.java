package com.example.petever.account.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmaulAuth")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAuthEntity {
    @Id
    private String email;
    private String code;
    private boolean isUse;
}
