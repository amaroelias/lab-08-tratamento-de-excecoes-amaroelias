package com.ufpb.GestorRepositorios.services;

import com.ufpb.GestorRepositorios.exception.ItemNotFoundException;
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
        return this.organizacaoRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Organizacao not found"));
    }

    public Organizacao createOrganizacao(Organizacao organizacao) {
        return this.organizacaoRepository.save(organizacao);
    }

    public Organizacao updateOrganizacao(Long id, Organizacao organizacao) {
        Organizacao toUpdate = organizacaoRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Organizacao not found"));
        toUpdate.setNome(organizacao.getNome());
        toUpdate.setUsers(organizacao.getUsers());
        toUpdate.setRepositorios(organizacao.getRepositorios());
        return this.organizacaoRepository.save(toUpdate);
    }

    public void deleteOrganizacao(Long id) {
        if (!this.organizacaoRepository.existsById(id)) {
            throw new ItemNotFoundException("Organizacao not found");
        }
        this.organizacaoRepository.deleteById(id);
    }
}
