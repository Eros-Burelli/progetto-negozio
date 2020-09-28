package com.eros.negozio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eros.negozio.model.Immagine;

@Repository("immagineRepository")
public interface ImmagineRepository extends JpaRepository<Immagine, Long> {
    @Query(value = "Select * from immagine where nome like ?1", nativeQuery = true)
    Immagine findByName(String nome);
}
