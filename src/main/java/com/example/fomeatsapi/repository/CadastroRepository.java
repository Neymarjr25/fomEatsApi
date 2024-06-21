package com.example.fomeatsapi.repository;

import com.example.fomeatsapi.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    /**
     * Busca um cadastro pelo email.
     *
     * @param email Email do cadastro a ser buscado
     * @return Optional contendo o cadastro encontrado ou vazio se não encontrado
     */
    Optional<Cadastro> findByEmail(String email);

    /**
     * Busca todos os cadastros ordenados pelo nome.
     *
     * @return Lista de todos os cadastros ordenados pelo nome
     */
    List<Cadastro> findAllByOrderByNome();

    /**
     * Salva um cadastro na base de dados.
     *
     * @param cadastro Cadastro a ser salvo
     * @return Cadastro salvo
     */
    @Override
    Cadastro save(Cadastro cadastro);
}
