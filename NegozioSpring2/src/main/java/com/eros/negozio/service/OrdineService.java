package com.eros.negozio.service;

import java.util.List;

import com.eros.negozio.model.Ordine;

public interface OrdineService{
    public void salva(Ordine o);
    public List<Ordine> getAll();
    public void delete(Long id);
}
