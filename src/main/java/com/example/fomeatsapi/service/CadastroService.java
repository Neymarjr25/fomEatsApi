package com.example.fomeatsapi.service;

import com.example.fomeatsapi.dto.EdicaoFuncionarioDTO;
import com.example.fomeatsapi.model.Cadastro;
import com.example.fomeatsapi.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CadastroService {

    private CadastroRepository cadastroRepository;

    @Autowired
    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Cadastro cadastrarUsuario(Cadastro cadastroDTO) {
        Cadastro usuario = new Cadastro();
        usuario.setNome(cadastroDTO.getNome());
        usuario.setEmail(cadastroDTO.getEmail());
        usuario.setSenha(cadastroDTO.getSenha());
        usuario.setDataNascimento(cadastroDTO.getDataNascimento());
        usuario.setNumero(cadastroDTO.getNumero());
        usuario.setEndereco(cadastroDTO.getEndereco());

        return cadastroRepository.save(usuario);
    }

    public Optional<Cadastro> buscarPorEmail(String email) {
        return cadastroRepository.findByEmail(email);
    }

    public Optional<Cadastro> buscarPorId(Long id) {
        return cadastroRepository.findById(id);
    }

    public Cadastro atualizarDadosFuncionario(Long id, @Valid EdicaoFuncionarioDTO edicaoDTO) {
        Optional<Cadastro> optionalCadastro = cadastroRepository.findById(id);

        if (optionalCadastro.isPresent()) {
            Cadastro cadastro = optionalCadastro.get();
            cadastro.setNome(edicaoDTO.getNome());
            cadastro.setEmail(edicaoDTO.getEmail());
            cadastro.setDataNascimento(edicaoDTO.getDataNascimento());
            cadastro.setNumero(edicaoDTO.getNumero());
            cadastro.setEndereco(edicaoDTO.getEndereco());

            return cadastroRepository.save(cadastro);
        } else {
            throw new IllegalArgumentException("Funcionário não encontrado para o ID: " + id);
        }
    }
}
