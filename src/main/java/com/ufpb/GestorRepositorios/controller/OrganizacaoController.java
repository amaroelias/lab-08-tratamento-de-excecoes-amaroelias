package com.ufpb.GestorRepositorios.controller;

import com.ufpb.GestorRepositorios.dto.OrganizacaoDTO;
import com.ufpb.GestorRepositorios.mappers.OrganizacaoMapper;
import com.ufpb.GestorRepositorios.models.Organizacao;
import com.ufpb.GestorRepositorios.services.OrganizacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizacaoController {
    private OrganizacaoService organizacaoService;
    private OrganizacaoMapper organizacaoMapper;

    public OrganizacaoController(OrganizacaoService organizacaoService, OrganizacaoMapper organizacaoMapper) {
        this.organizacaoService = organizacaoService;
        this.organizacaoMapper = organizacaoMapper;
    }

    @GetMapping(path = "/organizacoes")
    public List<Organizacao> getOrganizacoes(){
       return this.organizacaoService.listOrganizacao();
    }

    @GetMapping(path = "/organizacoes/{organizacaoId}")
    public Organizacao getOrganizacao(@PathVariable Long organizacaoId) {
        return this.organizacaoService.getOrganizacao(organizacaoId);
    }

    @PostMapping(path = "/organizacoes")
    public OrganizacaoDTO createOrganizacao(@Valid @RequestBody OrganizacaoDTO organizacaoDTO) {
        Organizacao organizacaoCreated = this.organizacaoService.createOrganizacao(this.organizacaoMapper.toEntity(organizacaoDTO));
        return this.organizacaoMapper.toDTO(organizacaoCreated);
    }

    @PutMapping(path = "/organizacoes/{organizacaoId}")
    public OrganizacaoDTO updateOrganizacao(@Valid @PathVariable Long organizacaoId, @RequestBody OrganizacaoDTO organizacaoDTO) {
        Organizacao organizacaoUpdated = this.organizacaoService.updateOrganizacao(organizacaoId, organizacaoMapper.toEntity(organizacaoDTO));
        return this.organizacaoMapper.toDTO(organizacaoUpdated);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/organizacoes/{organizacaoId}")
    public void deleteOrganizacao(@PathVariable Long organizacaoId) {
        this.organizacaoService.deleteOrganizacao(organizacaoId);
    }


}
