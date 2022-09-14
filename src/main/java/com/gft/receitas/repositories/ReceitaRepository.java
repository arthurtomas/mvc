package com.gft.receitas.repositories;

import com.gft.receitas.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByNomeContains(String nome);
    List<Receita> findByItensStringContains(String itensString);
}
