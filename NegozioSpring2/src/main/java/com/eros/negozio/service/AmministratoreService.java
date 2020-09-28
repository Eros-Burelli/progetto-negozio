package com.eros.negozio.service;

import com.eros.negozio.model.Amministratore;

public interface AmministratoreService {
    public String getAdminPass(String username);
    public Amministratore getAdminByUser(String username);
}
