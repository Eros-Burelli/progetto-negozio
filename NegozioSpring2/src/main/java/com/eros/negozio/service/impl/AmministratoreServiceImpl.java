package com.eros.negozio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eros.negozio.model.Amministratore;
import com.eros.negozio.repository.AmministratoreRepository;
import com.eros.negozio.service.AmministratoreService;

@Service("amministratoreService")
public class AmministratoreServiceImpl implements AmministratoreService {
    @Autowired
    private AmministratoreRepository amministratoreRepository;

    @Override
    public String getAdminPass(String username) {
	return amministratoreRepository.getAdminPass(username);
    }

    @Override
    public Amministratore getAdminByUser(String username) {
	return amministratoreRepository.getAdminByUser(username);
    }

}
