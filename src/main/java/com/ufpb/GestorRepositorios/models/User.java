package com.ufpb.GestorRepositorios.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tbUsers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "user")
    private Photo photo;

    @ManyToMany
    @JoinTable(
            name = "tb_user_organizacao",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "org_id")
    )
    private Collection<Organizacao> organizacoes;

    public User(Long userId, String nome, String email, Photo photo) {
        this.userId = userId;
        this.nome = nome;
        this.email = email;
        this.photo = photo;
    }

    public User() {
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

    public Collection<Organizacao> getOrganizacoes() {
        return organizacoes;
    }

    public void setOrganizacoes(Collection<Organizacao> organizacoes) {
        this.organizacoes = organizacoes;
    }
}
