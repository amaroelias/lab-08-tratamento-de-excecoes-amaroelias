package com.ufpb.GestorRepositorios.repositories;

import com.ufpb.GestorRepositorios.models.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

}