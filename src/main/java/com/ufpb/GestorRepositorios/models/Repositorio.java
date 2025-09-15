package com.ufpb.GestorRepositorios.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbRepositorios")
public class Repositorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "repositorio_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String nome;

    @Column(name = "is_privado")
    private boolean isPrivado;

    @ManyToOne()
    @JoinColumn(name = "org_id")
    private Organizacao organizacao;

    public Repositorio() {
    }

    public Repositorio(String nome, Long userId, boolean isPrivado, Organizacao organizacao) {
        this.nome = nome;
        this.userId = userId;
        this.isPrivado = isPrivado;
        this.organizacao = organizacao;
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

    public boolean isPrivado() {
        return isPrivado;
    }

    public void setIsPrivado(boolean privado) {
        isPrivado = privado;
    }

    public Organizacao getOrganizacao() {
        return this.organizacao;
    }
}