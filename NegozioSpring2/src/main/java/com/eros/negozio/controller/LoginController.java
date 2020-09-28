package com.eros.negozio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eros.negozio.model.Amministratore;
import com.eros.negozio.model.Carrello;
import com.eros.negozio.model.Utente;
import com.eros.negozio.service.AmministratoreService;
import com.eros.negozio.service.UtenteService;

@Controller
public class LoginController {
    	@Autowired
    	private UtenteService utenteService;
    	@Autowired
    	private AmministratoreService amministratoreService;
    	
    	@RequestMapping(value="/login")
    	public ModelAndView loginPage() {
    	    ModelAndView mv = new ModelAndView();
    	    mv.addObject("utente", new Utente());
    	    mv.setViewName("login");
    	    return mv;
    	}
    	
    	
    	@RequestMapping(value="/loginEffettivo", method = RequestMethod.POST)
    	public ModelAndView loginEff(@Valid Utente utente, @Valid Amministratore amm, BindingResult br, HttpServletRequest request) {
    	    HttpSession session; 
    	    String username = utente.getUsername();
    	    String password = utente.getPassword();
    	    String userPass = utenteService.getUserPass(username);
    	    String adminPass = amministratoreService.getAdminPass(username);
    	    if(userPass != null) {
    		if(userPass.equals(password)){
    		    session = request.getSession();
    		    utente = utenteService.getUtenteByUser(username);
    		    session.setAttribute("utente", utente);
    		    session.setAttribute("carrello", new Carrello());
    		    return new ModelAndView("redirect:/articoli");
    		}else{
    		   return new ModelAndView("login");
    		}
    	    }else if(adminPass != null) {
    		if(adminPass.equals(password)) {
    		    session = request.getSession();
    		    amm = amministratoreService.getAdminByUser(username);
    		    session.setAttribute("amministratore", amm);
      		    return new ModelAndView("redirect:/visualizzaordini");
    		}else {
    		    return new ModelAndView("login");
    		}
    	    }
    	    return new ModelAndView("login");
    	}
    	
    	@RequestMapping(value = "/logout")
    	public ModelAndView logout(HttpServletRequest request) {
    	    HttpSession session = request.getSession();
    	    session.invalidate();
    	    return new ModelAndView("/home");
    	}
}
