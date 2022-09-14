package com.gft.receitas.controllers;

import com.gft.receitas.services.IngredienteService;
import com.gft.receitas.services.ReceitaService;
import com.gft.receitas.services.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class PopularController {

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private IngredienteService ingredienteService;

    @Autowired
    private UnidadeMedidaService unidadeMedidaService;

    @RequestMapping
    public ModelAndView mandarLista() {

        ModelAndView mv = new ModelAndView("index.html");
        mv.addObject("listaReceita", receitaService.listarTodasReceitas());
        return mv;
    }

    @RequestMapping("popular")
    public ModelAndView Popular() {

        ModelAndView mv = new ModelAndView("redirect:/");

        if (receitaService.listarTodasReceitas().isEmpty())
            receitaService.popularBancoReceita();

        if (unidadeMedidaService.listarTodasUnidadeMedidas().isEmpty())
            unidadeMedidaService.popularBancoUnidadeMedida();

        if (ingredienteService.listarTodosIngredientes().isEmpty())
            ingredienteService.popularBancoIngredientes();

        return mv;
    }


}
