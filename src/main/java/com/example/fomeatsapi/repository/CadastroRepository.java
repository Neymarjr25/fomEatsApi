package com.example.fomeatsapi.repository;

import com.example.fomeatsapi.model.Cadastro;

import java.util.Optional;

public interface CadastroRepository {

    Optional<Cadastro> findByEmail(String email);

    Cadastro save();
}
