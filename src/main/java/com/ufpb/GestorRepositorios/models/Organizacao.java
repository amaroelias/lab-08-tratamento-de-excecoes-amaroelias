package com.ufpb.GestorRepositorios.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tbOrganizacoes")
public class Organizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "name")
    private String nome;

    @OneToMany(mappedBy = "organizacao")
    private Collection<Repositorio> repositorios;

    @ManyToMany(mappedBy = "organizacoes")
    private Collection<User> users;

    public Organizacao(String nome) {
        this.orgId = orgId;
        this.nome = nome;
    }
    public Organizacao() {}

    public Long getOrgId() {
        return orgId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Collection<Repositorio> getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(Collection<Repositorio> repositorios) {
        this.repositorios = repositorios;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
