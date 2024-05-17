package com.example.fomeatsapi.service;

import com.example.fomeatsapi.model.Login;
import com.example.fomeatsapi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validarCredenciais(String username, String password) {
        Login usuario = loginRepository.findByUsername(username);

        if (usuario != null && passwordEncoder.matches(password, usuario.getSenha())) {
            return true;
        } else {
            return false;
        }
    }
}
