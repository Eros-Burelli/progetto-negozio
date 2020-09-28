package com.eros.negozio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eros.negozio.model.Articolo;
import com.eros.negozio.repository.ArticoloRepository;
import com.eros.negozio.service.ArticoloService;

@Service("articoloService")
public class ArticoloServiceImpl implements ArticoloService {
    @Autowired
    private ArticoloRepository articoloRepository;

    @Override
    public void salvaArticolo(Articolo a) {
	articoloRepository.save(a);
    }

    @Override
    public Optional<Articolo> getById(Long id) {
	return articoloRepository.findById(id);
    }

    @Override
    public List<Articolo> getAll() {
	return articoloRepository.findAll();
    }

    @Override
    public void delete(Long id) {
	articoloRepository.deleteById(id);
    }




}

