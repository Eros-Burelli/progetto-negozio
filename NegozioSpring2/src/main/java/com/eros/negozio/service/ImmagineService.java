package com.eros.negozio.service;

import com.eros.negozio.model.Immagine;

public interface ImmagineService {
    public void salvaImmagine(Immagine img);
    public Immagine foundByName(String nome);
}
