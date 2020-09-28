package com.eros.negozio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eros.negozio.model.Immagine;
import com.eros.negozio.repository.ImmagineRepository;
import com.eros.negozio.service.ImmagineService;

@Service("immagineService")
public class ImmagineServiceImpl implements ImmagineService {
    @Autowired
    private ImmagineRepository immagineRepository;
    
    
    @Override
    public void salvaImmagine(Immagine img) {
	immagineRepository.save(img);
    }

    @Override
    public Immagine foundByName(String nome) {
	return immagineRepository.findByName(nome);
    }

}
