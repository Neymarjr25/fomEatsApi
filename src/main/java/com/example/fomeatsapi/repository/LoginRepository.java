package com.example.fomeatsapi.repository;

import com.example.fomeatsapi.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findByUsername(String username);

}
