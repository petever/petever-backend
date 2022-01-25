package com.example.petever.account.repository;

import com.example.petever.account.entity.EmailAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailAuthRepository extends JpaRepository<EmailAuthEntity, Integer> {
    Optional<EmailAuthEntity> findByEmail(String email);
    Optional<EmailAuthEntity> findByEmailAndCode(String email, String code);
    Optional<EmailAuthEntity> findFirstByEmailOrderByCreatedDateDesc(String email);
    List<EmailAuthEntity> findAllByEmail(String email);

}
