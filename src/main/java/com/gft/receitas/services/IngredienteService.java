package com.gft.receitas.services;

import com.gft.receitas.entities.Ingrediente;
import com.gft.receitas.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente salvarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    private List<Ingrediente> listarIngredientesPorNome(String nome) {
        return ingredienteRepository.findByNomeContains(nome);
    }

    public List<Ingrediente> listarTodosIngredientes() {
        return ingredienteRepository.findAll();
    }

    public List<Ingrediente> listarIngredientes(String nome) {
        if (nome != null)
            return listarIngredientesPorNome(nome);
        return listarTodosIngredientes();
    }

    public Ingrediente obterIngrediente(Long id) throws Exception {

        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
        if (ingrediente.isEmpty()) {
            throw new Exception("Ingrediente não encontrado.");
        }
        return ingrediente.get();
    }

    public void excluirIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }

    public void popularBancoIngredientes() {

        Ingrediente ingrediente01 = new Ingrediente("Ovo");
        salvarIngrediente(ingrediente01);

        Ingrediente ingrediente02 = new Ingrediente("Azeite de Oliva");
        salvarIngrediente(ingrediente02);

        Ingrediente ingrediente03 = new Ingrediente("Cebola");
        salvarIngrediente(ingrediente03);

        Ingrediente ingrediente04 = new Ingrediente("Alho");
        salvarIngrediente(ingrediente04);

        Ingrediente ingrediente05 = new Ingrediente("Batata");
        salvarIngrediente(ingrediente05);

        Ingrediente ingrediente06 = new Ingrediente("Pimenta");
        salvarIngrediente(ingrediente06);

        Ingrediente ingrediente07 = new Ingrediente("Iogurte Natural");
        salvarIngrediente(ingrediente07);

        Ingrediente ingrediente08 = new Ingrediente("Arroz");
        salvarIngrediente(ingrediente08);

        Ingrediente ingrediente09 = new Ingrediente("Feijão");
        salvarIngrediente(ingrediente09);

        Ingrediente ingrediente10 = new Ingrediente("Elemento X");
        salvarIngrediente(ingrediente10);

        Ingrediente ingrediente11 = new Ingrediente("Tomate");
        salvarIngrediente(ingrediente11);

        Ingrediente ingrediente12 = new Ingrediente("Vinho");
        salvarIngrediente(ingrediente12);

        Ingrediente ingrediente13 = new Ingrediente("Banana");
        salvarIngrediente(ingrediente13);

        Ingrediente ingrediente14 = new Ingrediente("Batata doce");
        salvarIngrediente(ingrediente14);

        Ingrediente ingrediente15 = new Ingrediente("Sal");
        salvarIngrediente(ingrediente15);

        Ingrediente ingrediente16 = new Ingrediente("Manteiga");
        salvarIngrediente(ingrediente16);


    }
}
