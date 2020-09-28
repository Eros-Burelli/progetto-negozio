package com.eros.negozio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eros.negozio.model.Articolo;
import com.eros.negozio.service.ArticoloService;

@Controller
public class ArticoloController {
    @Autowired
    private ArticoloService articoloService;

    
    //VISUALIZZAZIONE ARTICOLI CLIENTE
    @RequestMapping(value = "/articoli", method = RequestMethod.GET)
    public ModelAndView acquisti(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("utente") == null)
	    return new ModelAndView("redirect:/");
	ModelAndView mv = new ModelAndView();
	mv.setViewName("articoli");
	List<Articolo> listaArticoli = articoloService.getAll();
	mv.addObject("listaArticoli", listaArticoli);
	mv.addObject("articolo", new Articolo());
	return mv;
    }
    
    //PAGINA GESTIONE ARTICOLI
    @RequestMapping(value  = "/gestisciarticoli", method = RequestMethod.GET)
    public ModelAndView gestisciArticoli(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("amministratore") == null)
	    return new ModelAndView("redirect:/");
	ModelAndView mv = new ModelAndView();
	mv.setViewName("gestisciarticoli");
	List<Articolo> listaArticoli = articoloService.getAll();
	mv.addObject("listaArticoli", listaArticoli);
	mv.addObject("articolo", new Articolo());
	return mv;
    }
    
    //PAGINA INSERIMENTO NUOVO ARTICOLO
    @RequestMapping(value = "/aggiungiarticolo")
    public ModelAndView aggiungiArticolo() {
	ModelAndView mv = new ModelAndView();
	mv.addObject("articolo", new Articolo());
	return mv;
    }
    
    //SALVATAGGIO NUOVO ARTICOLO
    @RequestMapping(value = "/saveArticolo", method = RequestMethod.POST)
    public ModelAndView save(@Valid Articolo a, BindingResult br) {
	articoloService.salvaArticolo(a);
	return new ModelAndView("redirect:/gestisciarticoli");
    }
         
    //MODIFICA ARTICOLO
    @RequestMapping(value = "/modificaarticolo/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id, HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("amministratore") == null)
	    return new ModelAndView("redirect:/");
	ModelAndView mv = new ModelAndView();
	mv.setViewName("modificaarticolo");
	mv.addObject("articolo", articoloService.getById(id));
	return mv;
    }
    
    //ELIMINA ARTICOLO
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id){
	articoloService.delete(id);
	return new ModelAndView("redirect:/gestisciarticoli");
    }
    
}
