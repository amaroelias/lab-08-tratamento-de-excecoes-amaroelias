package com.ufpb.GestorRepositorios.services;

import com.ufpb.GestorRepositorios.models.Organizacao;
import com.ufpb.GestorRepositorios.repositories.OrganizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrganizacaoService {

    private OrganizacaoRepository organizacaoRepository;

    @Autowired
    public OrganizacaoService(OrganizacaoRepository organizacaoRepository) {
        this.organizacaoRepository = organizacaoRepository;
    }

    public List<Organizacao> listOrganizacao(){
        return this.organizacaoRepository.findAll();
    }

    public Organizacao getOrganizacao(Long id) {
        Organizacao organizacao = this.organizacaoRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organização com id: " + id + "não existe"));
        return organizacao;
    }

    public Organizacao createOrganizacao(Organizacao organizacao) {
        return this.organizacaoRepository.save(organizacao);
    }

    public Organizacao updateOrganizacao(Long id, Organizacao organizacao) {
        Organizacao toUpdate = organizacaoRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organização não encontrada com id: " + id));
        toUpdate.setNome(organizacao.getNome());
        toUpdate.setUsers(organizacao.getUsers());
        toUpdate.setRepositorios(organizacao.getRepositorios());
        return this.organizacaoRepository.save(toUpdate);
    }

    public void deleteOrganizacao(Long id) {
        if (!this.organizacaoRepository.existsById(id)) {
            throw new NoSuchElementException("Organização não encontrada com id: " + id);
        }
        this.organizacaoRepository.deleteById(id);
    }
}
