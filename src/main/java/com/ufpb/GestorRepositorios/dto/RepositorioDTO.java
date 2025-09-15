package com.ufpb.GestorRepositorios.dto;

import com.ufpb.GestorRepositorios.validation.NameRepo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RepositorioDTO {
    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    @NameRepo
    private String nome;

    public RepositorioDTO(Long id, Long userId, String nome) {
        this.id = id;
        this.userId = userId;
        this.nome = nome;
    }

    public RepositorioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "RepositorioDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", nome='" + nome + '\'' +
                '}';
    }
}
