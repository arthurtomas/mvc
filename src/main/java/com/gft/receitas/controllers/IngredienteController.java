package com.gft.receitas.controllers;

import com.gft.receitas.entities.Ingrediente;
import com.gft.receitas.services.IngredienteService;
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
@RequestMapping("ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

//  CRUD

//  Create
    @RequestMapping(method = RequestMethod.POST, path = "editar")
    public ModelAndView salvarIngrediente(@Valid Ingrediente ingrediente, BindingResult bindingResult) {

        ModelAndView mv = new ModelAndView("ingrediente/form.html");

        boolean novo = ingrediente.getId() == null;

        if (bindingResult.hasErrors()) {
            mv.addObject("ingrediente", ingrediente);
            return mv;
        }

        ingredienteService.salvarIngrediente(ingrediente);

        if (novo) {
            mv.addObject("ingrediente", new Ingrediente());
        }else {
            mv.addObject("ingrediente", ingrediente);
        }

        mv.addObject("mensagem", "Ingrediente salvo com sucesso.");

        return mv;
    }

//  Read
    @RequestMapping
    public ModelAndView listarIngredientes(String nome) {

        ModelAndView mv = new ModelAndView("ingrediente/listar.html");
        mv.addObject("lista", ingredienteService.listarIngredientes(nome));
        mv.addObject("nome", nome);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, path = "visualizar")
    public ModelAndView visualizarIngrediente(@RequestParam(required = false) Long id) {

        ModelAndView mv = new ModelAndView("ingrediente/visualizar.html");
        Ingrediente ingrediente;

        if (id==null) {
            ingrediente = new Ingrediente();
        }else {
            try {
                ingrediente = ingredienteService.obterIngrediente(id);
            }catch (Exception e) {
                ingrediente = new Ingrediente();
                mv.addObject("mensagem", e.getMessage());
            }
        }

        mv.addObject("ingrediente", ingrediente);

        return mv;
    }

//  Update
    @RequestMapping("editar")
    public ModelAndView editarIngrediente(@RequestParam(required = false) Long id) {

        ModelAndView mv = new ModelAndView("ingrediente/form.html");
        Ingrediente ingrediente;

        if (id==null) {
            ingrediente = new Ingrediente();
        }else {
            try {
                ingrediente = ingredienteService.obterIngrediente(id);
            }catch (Exception e) {
                ingrediente = new Ingrediente();
                mv.addObject("mensagem", e.getMessage());
            }
        }

        mv.addObject("ingrediente", ingrediente);

        return mv;
    }

//  Delete
    @RequestMapping("excluir")
    public ModelAndView excluirIngrediente(@RequestParam Long id, RedirectAttributes redirectAttributes) {

        ModelAndView mv = new ModelAndView("redirect:/ingrediente");

        try {
            ingredienteService.excluirIngrediente(id);
            redirectAttributes.addFlashAttribute("mensagem", "Ingrediente excluído com sucesso.");
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir ingrediente."+e.getMessage());
        }

        return mv;
    }
}
