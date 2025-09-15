package com.ufpb.GestorRepositorios.dto;

import jakarta.validation.constraints.NotBlank;

public class OrganizacaoDTO {
    private Long orgId;

    @NotBlank
    private String nome;

    public OrganizacaoDTO(Long orgId, String nome) {
        this.orgId = orgId;
        this.nome = nome;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "OrganizacaoDTO{" +
                "orgId=" + orgId +
                ", nome='" + nome + '\'' +
                '}';
    }
}
