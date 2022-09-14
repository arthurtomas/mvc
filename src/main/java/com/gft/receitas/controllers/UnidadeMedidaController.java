package com.gft.receitas.controllers;

import com.gft.receitas.entities.UnidadeMedida;
import com.gft.receitas.services.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaService unidadeMedidaService;

    @RequestMapping(path = "editar")
    public ModelAndView editarUnidadeMedida(@RequestParam(required = false) Long id) {

        ModelAndView mv = new ModelAndView("medida/form.html");
        UnidadeMedida unidadeMedida;

        if (id==null) {
            unidadeMedida = new UnidadeMedida();
        } else {
            try {
                unidadeMedida = unidadeMedidaService.obterUnidadeMedida(id);
            }catch (Exception e) {
                unidadeMedida = new UnidadeMedida();
                mv.addObject("mensagem", e.getMessage());
            }
        }

        mv.addObject("medida", unidadeMedida);

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, path = "editar")
    public ModelAndView salvarUnidadeMedida(@Valid UnidadeMedida unidadeMedida, BindingResult bindingResult) {

        ModelAndView mv = new ModelAndView("medida/form.html");

        boolean novo = unidadeMedida.getId() == null;

        if (bindingResult.hasErrors()) {
            mv.addObject("medida", unidadeMedida);
            return mv;
        }

        unidadeMedidaService.salvarUnidadeMedida(unidadeMedida);

        if (novo) {
            mv.addObject("medida", new UnidadeMedida());
        }else {
            mv.addObject("medida", unidadeMedida);
        }

        mv.addObject("mensagem", "Unidade de medida salva com sucesso.");

        return mv;
    }

    @RequestMapping
    public ModelAndView listarUnidadeMedidas(String nome) {

        ModelAndView mv = new ModelAndView("medida/listar.html");
        mv.addObject("lista", unidadeMedidaService.listarUnidadeMedidas(nome));
        mv.addObject("nome", nome);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, path = "visualizar")
    public ModelAndView visualizarUnidadeMedida(@RequestParam(required = false) Long id) {

        ModelAndView mv = new ModelAndView("medida/visualizar.html");
        UnidadeMedida unidadeMedida;

        if (id==null) {
            unidadeMedida = new UnidadeMedida();
        }else {
            try {
                unidadeMedida = unidadeMedidaService.obterUnidadeMedida(id);
            }catch (Exception e) {
                unidadeMedida = new UnidadeMedida();
                mv.addObject("mensagem", e.getMessage());
            }
        }

        mv.addObject("medida", unidadeMedida);

        return mv;
    }

    @RequestMapping("/excluir")
    public ModelAndView excluirUnidadeMedida(@RequestParam Long id, RedirectAttributes redirectAttributes) {

        ModelAndView mv = new ModelAndView("redirect:/medida");

        try {
            unidadeMedidaService.excluirUnidadeMedida(id);
            redirectAttributes.addFlashAttribute("mensagem", "Unidade de medida excluída com sucesso.");
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir unidade de medida."+e.getMessage());
        }

        return mv;
    }
}
