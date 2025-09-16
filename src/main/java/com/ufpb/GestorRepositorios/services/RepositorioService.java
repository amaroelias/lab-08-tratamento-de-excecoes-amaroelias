package com.ufpb.GestorRepositorios.services;

import com.ufpb.GestorRepositorios.exception.ItemNotFoundException;
import com.ufpb.GestorRepositorios.models.Repositorio;
import com.ufpb.GestorRepositorios.repositories.RepositorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RepositorioService {

    private final RepositorioRepository repositorioRepository;

    @Autowired
    public RepositorioService(RepositorioRepository repositorioRepository) {
        this.repositorioRepository = repositorioRepository;
    }

    public List<Repositorio> listRepositorios() {
        return this.repositorioRepository.findAll();
    }

    public List<Repositorio> listRepositorios(Long userId) {
        if(!repositorioRepository.existsById(userId)) {
            throw new ItemNotFoundException("Repositorio not found");
        }
        return this.repositorioRepository.findByUserId(userId);
    }

    public Repositorio createRepositorio(Repositorio r) {
        return this.repositorioRepository.save(r);
    }

    public Repositorio updateRepositorio(Long id, Repositorio r) {
        Repositorio toUpdate = this.repositorioRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Repositorio not found"));
        toUpdate.setNome(r.getNome());
        toUpdate.setUserId(r.getUserId());
        toUpdate.setIsPrivado(r.isPrivado());
        return this.repositorioRepository.save(toUpdate);
    }

    public void deleteRepositorio(Long id) {
        if (!this.repositorioRepository.existsById(id)) {
            throw new ItemNotFoundException("Repositorio not found");
        }
        this.repositorioRepository.deleteById(id);
    }
}