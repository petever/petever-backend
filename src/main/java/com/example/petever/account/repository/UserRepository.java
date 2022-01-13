package com.example.petever.account.repository;

import com.example.petever.account.dto.UserDto;
import com.example.petever.account.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    int countByEmailAndPassword(String email, String password);

}
