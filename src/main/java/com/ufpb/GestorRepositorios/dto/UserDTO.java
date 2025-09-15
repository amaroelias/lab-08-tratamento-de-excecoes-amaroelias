package com.ufpb.GestorRepositorios.dto;

import com.ufpb.GestorRepositorios.models.Photo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    private Long userId;

    @NotBlank
    private String nome;

    @Email
    private String email;
    private Photo photo;

    public UserDTO(Long userId, String nome, Photo photo, String email) {
        this.userId = userId;
        this.nome = nome;
        this.photo = photo;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + photo +
                '}';
    }
}
