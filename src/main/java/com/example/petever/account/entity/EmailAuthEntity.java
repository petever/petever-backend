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
@Table(name = "email_auth")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAuthEntity extends BaseTimeEntity {
    @Id
    private String email;
    private String code;
    private boolean isUse;

    public void changeMailUse(boolean isUse) {
        this.isUse = isUse;
    }
}
