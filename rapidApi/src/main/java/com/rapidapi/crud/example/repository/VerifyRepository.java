package com.rapidapi.crud.example.repository;

import com.rapidapi.crud.example.entity.Verify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifyRepository extends JpaRepository<Verify,Integer> {
    Verify findByName(String name);
}

