package com.eros.negozio.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eros.negozio.model.Carrello;
import com.eros.negozio.model.Ordine;
import com.eros.negozio.model.Utente;
import com.eros.negozio.service.OrdineService;

@Controller
public class OrdineController {
    @Autowired
    private OrdineService ordineService;
    
    @RequestMapping(value = "/salvaordine", method = RequestMethod.GET)
    public ModelAndView salvaOrdine(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("utente") == null)
	    return new ModelAndView("redirect:/");
	Ordine ordine = new Ordine();
	ordine.setData(new Date());
	ordine.setTotale((Double)session.getAttribute("totale"));
	ordine.setUtente((Utente)session.getAttribute("utente"));
	ordineService.salva(ordine);
	session.setAttribute("carrello", new Carrello());
	return new ModelAndView("/confermaacquisto");
    }
    
    @RequestMapping(value = "/visualizzaordini", method = RequestMethod.GET)
    public ModelAndView visualizzaOrdini(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if(session.getAttribute("amministratore") == null)
	    return new ModelAndView("redirect:/");
	ModelAndView mv = new ModelAndView();
	List<Ordine> listaOrdini = ordineService.getAll();
	mv.addObject("listaOrdini", listaOrdini);
	return mv;
    }
    
    
}
