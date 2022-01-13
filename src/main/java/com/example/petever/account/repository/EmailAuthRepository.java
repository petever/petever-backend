package com.example.petever.account.repository;

import com.example.petever.account.entity.EmailAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAuthRepository extends JpaRepository<EmailAuthEntity, Integer> {
    EmailAuthEntity findByEmail(String email);

    EmailAuthEntity findByEmailAndCode(String email, String code);
}
