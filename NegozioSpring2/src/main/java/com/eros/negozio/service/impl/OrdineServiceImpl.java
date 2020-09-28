package com.eros.negozio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eros.negozio.model.Ordine;
import com.eros.negozio.repository.OrdineRepository;
import com.eros.negozio.service.OrdineService;

@Service("ordineService")
public class OrdineServiceImpl implements OrdineService{
    @Autowired
    private OrdineRepository ordineRepository;
    
    @Override
    public void salva(Ordine o) {
	ordineRepository.save(o);
    }

    @Override
    public List<Ordine> getAll() {
	return ordineRepository.findAll();
    }

    @Override
    public void delete(Long id) {
	ordineRepository.deleteById(id);
    }

}
