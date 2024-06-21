package com.example.fomeatsapi.controller;

import com.example.fomeatsapi.dto.EdicaoFuncionarioDTO;
import com.example.fomeatsapi.model.Cadastro;
import com.example.fomeatsapi.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    private final CadastroService cadastroService;

    @Autowired
    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cadastro> cadastrarUsuario(@Valid @RequestBody Cadastro cadastroModel) {
        Cadastro usuario = cadastroService.cadastrarUsuario(cadastroModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<Cadastro> buscarUsuarioPorEmail(@PathVariable String email) {
        Optional<Cadastro> usuario = cadastroService.buscarPorEmail(email);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cadastro> editarFuncionario(
            @PathVariable Long id,
            @Valid @RequestBody EdicaoFuncionarioDTO edicaoDTO) {

        Cadastro funcionarioAtualizado = cadastroService.atualizarDadosFuncionario(id, edicaoDTO);
        return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
    }
}
