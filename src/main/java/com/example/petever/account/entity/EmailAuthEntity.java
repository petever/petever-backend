package com.example.petever.account.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "EmaulAuth")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAuthEntity {
    @Id
    private String email;
    private String code;
    private boolean isUse;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public void changeMailUse(boolean isUse) {
        this.isUse = isUse;
    }
}
