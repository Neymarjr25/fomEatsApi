package com.example.fomeatsapi.dto;

import jakarta.validation.constraints.NotNull;

public class LoginDTO {

    @NotNull
    private String email;

    @NotNull
    private String senha;

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
