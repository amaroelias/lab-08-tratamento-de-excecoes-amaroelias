package com.ufpb.GestorRepositorios.controller;

import com.ufpb.GestorRepositorios.dto.RepositorioDTO;
import com.ufpb.GestorRepositorios.mappers.RepositorioMapper;
import com.ufpb.GestorRepositorios.models.Repositorio;
import com.ufpb.GestorRepositorios.services.RepositorioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RepositorioController {

    private final RepositorioService repositorioService;
    RepositorioMapper repositorioMapper;

    public RepositorioController(RepositorioService repositorioService, RepositorioMapper repositorioMapper) {
        this.repositorioService = repositorioService;
        this.repositorioMapper = repositorioMapper;
    }

    @GetMapping(path = "/repositorios/{userId}")
    public List<Repositorio> getRepositorios(@PathVariable Long userId) {
        return repositorioService.listRepositorios(userId);
    }

    @GetMapping(path = "/repositorios")
    public List<Repositorio> getAllRepositorios() {
        return repositorioService.listRepositorios();
    }

    @PostMapping("/repositorios")
    public RepositorioDTO createRepositorio(@Valid @RequestBody RepositorioDTO repositorioDTO) {
        Repositorio repositorioCreated = repositorioService.createRepositorio(repositorioMapper.toEntity(repositorioDTO));
        return repositorioMapper.toDTO(repositorioCreated);
    }

    @PutMapping("/repositorios/{repositorioId}")
    public RepositorioDTO updateRepositorio(@Valid @PathVariable Long repositorioId, @RequestBody RepositorioDTO repositorioDTO) {
        Repositorio repositorioUpdated = repositorioService.updateRepositorio(repositorioId, repositorioMapper.toEntity(repositorioDTO));
        return repositorioMapper.toDTO(repositorioUpdated);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/repositorios/{repositorioId}")
    public void deleteRepositorio(@PathVariable Long repositorioId) {
        repositorioService.deleteRepositorio(repositorioId);
    }

}