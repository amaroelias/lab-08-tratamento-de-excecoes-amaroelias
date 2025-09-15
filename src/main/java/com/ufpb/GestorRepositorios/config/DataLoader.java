package com.ufpb.GestorRepositorios.config;

import com.ufpb.GestorRepositorios.models.Repositorio;
import com.ufpb.GestorRepositorios.repositories.RepositorioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader {

//    @Bean
//    public CommandLineRunner loadInitialData(RepositorioRepository repositorioRepository) {
//        return args -> {
//            repositorioRepository.deleteAll();
//
//            repositorioRepository.saveAll(Arrays.asList(
//                    new Repositorio("servico-de-autenticacao", 101L, true),
//                    new Repositorio("website-institucional", 205L, false),
//                    new Repositorio("app-mobile-android", 300L, true),
//                    new Repositorio("servico-de-pagamentos", 410L, true),
//                    new Repositorio("relatorios-financeiros", 410L, true),
//                    new Repositorio("projeto-legado-manutencao", 50L, true),
//                    new Repositorio("design-system-ui", 205L, false),
//                    new Repositorio("data-analytics-pipeline", 620L, true)
//            ));
//        };
//    }
}