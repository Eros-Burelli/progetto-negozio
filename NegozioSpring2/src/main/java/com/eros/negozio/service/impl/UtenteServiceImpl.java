package com.eros.negozio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eros.negozio.model.Utente;
import com.eros.negozio.repository.UtenteRepository;
import com.eros.negozio.service.UtenteService;

@Service("utenteService")
public class UtenteServiceImpl implements UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void salvaUtente(Utente u) {
	utenteRepository.save(u);
    }

    @Override
    public Utente getById(Long id) {
	return utenteRepository.findById(id).get();
    }

    @Override
    public String getUserPass(String username) {

	return utenteRepository.getUserPass(username);

    }

    @Override
    public Utente getUtenteByUser(String username) {
	return utenteRepository.getUtenteByUser(username);
    }
}
