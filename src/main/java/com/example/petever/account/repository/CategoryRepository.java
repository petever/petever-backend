package com.example.petever.account.repository;

import com.example.petever.account.entity.CategoryEntity;
import com.example.petever.account.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findByRegistrant(String email);
}
