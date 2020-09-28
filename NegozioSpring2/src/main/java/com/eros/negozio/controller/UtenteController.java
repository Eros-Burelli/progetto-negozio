package com.eros.negozio.controller;

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

import com.eros.negozio.model.Utente;
import com.eros.negozio.service.UtenteService;

@Controller
public class UtenteController {
    @Autowired
    private UtenteService utenteService; 
    @RequestMapping(value = "/registra", method = RequestMethod.GET)
    public ModelAndView registra(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("utente") != null)
	    return new ModelAndView("redirect:/");
	ModelAndView mv = new ModelAndView();
	mv.addObject("utente", new Utente());
	return mv;
    }
    
    @RequestMapping(value = "/saveUtente", method = RequestMethod.POST)
    public ModelAndView salvaUtente(@Valid Utente u, BindingResult br) {
	utenteService.salvaUtente(u);
	return new ModelAndView("confermaregistrazione");
    }
    
    @RequestMapping(value ="/modificautente/{id}", method = RequestMethod.GET)
    public ModelAndView modificaUtente(@PathVariable Long id, HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("utente") == null)
	    return new ModelAndView("redirect:/");
	ModelAndView mv = new ModelAndView();
	mv.setViewName("/modificautente");
	mv.addObject("utente", utenteService.getById(id));
	return mv;
    }
    
    @RequestMapping(value = "/dettagliutente/{id}", method = RequestMethod.GET)
    public ModelAndView getUtente(@PathVariable Long id){
	ModelAndView mv = new ModelAndView();
	//Long id2 = Long.parseLong(id);
	mv.setViewName("dettagliutente");
	Utente utente = utenteService.getById(id);
	mv.addObject("utente", utente);
	return mv;
    }
}
