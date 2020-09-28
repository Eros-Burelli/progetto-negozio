package com.eros.negozio.service;

import java.util.List;
import java.util.Optional;

import com.eros.negozio.model.Articolo;

public interface ArticoloService {
    public void salvaArticolo(Articolo a);
    public Optional<Articolo> getById(Long id);
    public List<Articolo> getAll();
    public void delete(Long id);
} 
