package com.ufpb.GestorRepositorios.mappers;

import com.ufpb.GestorRepositorios.dto.OrganizacaoDTO;
import com.ufpb.GestorRepositorios.models.Organizacao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrganizacaoMapper {

    private final ModelMapper modelMapper;

    public OrganizacaoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrganizacaoDTO toDTO(Organizacao organizacao) {
        return this.modelMapper.map(organizacao, OrganizacaoDTO.class);
    }

    public Organizacao toEntity(OrganizacaoDTO organizacaoDTO) {
        return this.modelMapper.map(organizacaoDTO, Organizacao.class);
    }

}
