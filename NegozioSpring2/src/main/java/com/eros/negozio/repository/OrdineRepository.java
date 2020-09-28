package com.eros.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eros.negozio.model.Ordine;

@Repository("ordineRepository")
public interface OrdineRepository extends JpaRepository<Ordine, Long>{

}
