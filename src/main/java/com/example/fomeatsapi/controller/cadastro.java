package com.example.fomeatsapi.controller;

import com.example.fomeatsapi.model.Cadastro;
import com.example.fomeatsapi.repository.CadastroRepository;
import com.example.fomeatsapi.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/cadastro")
public class cadastro {

    @Autowired
    private CadastroService cadastroService;
    private CadastroRepository cadastroRepository;

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

}
