package com.ufpb.GestorRepositorios.mappers;

import com.ufpb.GestorRepositorios.dto.RepositorioDTO;
import com.ufpb.GestorRepositorios.models.Repositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RepositorioMapper {

    private final ModelMapper modelMapper;

    public RepositorioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RepositorioDTO toDTO(Repositorio repositorio) {
        return this.modelMapper.map(repositorio, RepositorioDTO.class);
    }

    public Repositorio toEntity(RepositorioDTO repositorioDTO) {
        return this.modelMapper.map(repositorioDTO, Repositorio.class);
    }

}
