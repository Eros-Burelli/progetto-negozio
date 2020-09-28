package com.eros.negozio.service;

import com.eros.negozio.model.Utente;

public interface UtenteService {
    public void salvaUtente(Utente u);
    public Utente getById(Long id);
    public String getUserPass(String username);
    public Utente getUtenteByUser(String username);
}
