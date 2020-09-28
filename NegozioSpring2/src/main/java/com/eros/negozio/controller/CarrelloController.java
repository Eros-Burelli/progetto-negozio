package com.eros.negozio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eros.negozio.model.Articolo;
import com.eros.negozio.model.Carrello;
import com.eros.negozio.service.ArticoloService;

@Controller
public class CarrelloController {
    @Autowired
    private ArticoloService articoloService;
    
    @RequestMapping(value = "/aggiungi/{id}", method = RequestMethod.GET)
    public ModelAndView aggiungiArticolo(@PathVariable Long id, HttpServletRequest request){
	HttpSession session = request.getSession();
	Carrello carrello = (Carrello) session.getAttribute("carrello");
	ModelAndView mv = new ModelAndView();
	Articolo articolo = articoloService.getById(id).get();	
	carrello.aggiungiArticolo(String.valueOf(articolo.getId_Articolo()), articolo.getMarca(), articolo.getModello(), articolo.getPrezzo());
	mv.addObject("carrello", carrello );
	return new ModelAndView("redirect:/articoli");
    }
    
    @RequestMapping(value = "/carrello", method = RequestMethod.GET)
    public ModelAndView visualizzaCarrello(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("utente") == null)
	    return new ModelAndView("redirect:/");
	Carrello carrello = (Carrello) session.getAttribute("carrello");
	ModelAndView mv = new ModelAndView();
	session.setAttribute("totale", carrello.totaleComplessivo());
	mv.addObject("listaArticoli", carrello.listaArticoli());
	mv.addObject("totaleComplessivo", carrello.totaleComplessivo());
	return mv;
    }
    
    @RequestMapping(value ="/rimuoviarticolo/{id}", method = RequestMethod.GET)
    public ModelAndView rimuoviArticolo(@PathVariable String id, HttpServletRequest request){
	HttpSession session = request.getSession();
	ModelAndView mv = new ModelAndView();
	Carrello carrello = (Carrello) session.getAttribute("carrello");
	carrello.rimuoviArticolo(id);
	mv.addObject("carrello", carrello);
	return new ModelAndView("redirect:/carrello");
    }
    
    @RequestMapping(value ="/svuotacarrello")
    public ModelAndView svuotaCarrello(HttpServletRequest request) {
	HttpSession session = request.getSession();
	session.setAttribute("carrello", new Carrello());
	return new ModelAndView("redirect:/carrello");
    }
    
}
