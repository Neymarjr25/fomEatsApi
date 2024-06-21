package com.example.fomeatsapi.service;

import com.example.fomeatsapi.model.Login;
import com.example.fomeatsapi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean validarCredenciais(String email, String senha) {
        Login login = loginRepository.findByEmail(email);
        return login != null && login.getSenha().equals(senha);
    }
}
