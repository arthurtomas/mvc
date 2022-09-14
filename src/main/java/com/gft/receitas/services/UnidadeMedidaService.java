package com.gft.receitas.services;

import com.gft.receitas.entities.UnidadeMedida;
import com.gft.receitas.repositories.UnidadeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeMedidaService {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    public UnidadeMedida salvarUnidadeMedida(UnidadeMedida unidadeMedida) {
        return unidadeMedidaRepository.save(unidadeMedida);
    }

    public List<UnidadeMedida> listarUnidadeMedidas(String nome) {

        if (nome != null)
            return listarUnidadeMedidasPorNome(nome);
        return listarTodasUnidadeMedidas();

    }

    public List<UnidadeMedida> listarTodasUnidadeMedidas() {
        return unidadeMedidaRepository.findAll();
    }

    public List<UnidadeMedida> listarUnidadeMedidasPorNome(String nome) {
        return unidadeMedidaRepository.findByNomeContains(nome);
    }

    public UnidadeMedida obterUnidadeMedida(Long id) throws Exception {

        Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);
        if (unidadeMedida.isEmpty()) {
            throw new Exception("Unidade de medida não encontrado.");
        }

        return unidadeMedida.get();
    }

    public void excluirUnidadeMedida(Long id) {
        unidadeMedidaRepository.deleteById(id);
    }

    public void popularBancoUnidadeMedida() {

        UnidadeMedida unidadeMedida01 = new UnidadeMedida("Colher de Sopa");
        salvarUnidadeMedida(unidadeMedida01);

        UnidadeMedida unidadeMedida02 = new UnidadeMedida("Colher de chá");
        salvarUnidadeMedida(unidadeMedida02);

        UnidadeMedida unidadeMedida03 = new UnidadeMedida("Colher de café");
        salvarUnidadeMedida(unidadeMedida03);

        UnidadeMedida unidadeMedida04 = new UnidadeMedida("Xícara de chá");
        salvarUnidadeMedida(unidadeMedida04);

        UnidadeMedida unidadeMedida05 = new UnidadeMedida("Xícara de café");
        salvarUnidadeMedida(unidadeMedida05);

        UnidadeMedida unidadeMedida06 = new UnidadeMedida("Litros");
        salvarUnidadeMedida(unidadeMedida06);

        UnidadeMedida unidadeMedida07 = new UnidadeMedida("Mililitros");
        salvarUnidadeMedida(unidadeMedida07);

    }
}
