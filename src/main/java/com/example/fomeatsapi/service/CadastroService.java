package com.example.fomeatsapi.service;

import com.example.fomeatsapi.model.Cadastro;
import com.example.fomeatsapi.repository.CadastroRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CadastroService {

    private CadastroRepository cadastroRepository;

    public Cadastro cadastrarUsuario(@Valid Cadastro cadastroDTO) {
        Cadastro usuario = new Cadastro();
        usuario.setNome(cadastroDTO.getNome());
        usuario.setEmail(cadastroDTO.getEmail());
        usuario.setSenha(cadastroDTO.getSenha());
        usuario.setDataNascimento(cadastroDTO.getDataNascimento());
        usuario.setNumero(cadastroDTO.getNumero());
        usuario.setEndereco(cadastroDTO.getEndereco());

        return cadastroRepository.save();
    }

    public Optional<Cadastro> buscarPorEmail(String email) {
        return cadastroRepository.findByEmail(email);
    }
}
