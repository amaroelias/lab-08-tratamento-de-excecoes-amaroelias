package com.ufpb.GestorRepositorios.repositories;

import com.ufpb.GestorRepositorios.models.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioRepository extends JpaRepository<Repositorio, Long> {

    List<Repositorio> findByUserId(Long userId);

}
