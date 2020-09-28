package com.eros.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eros.negozio.model.Utente;

@Repository("utenteRepository")
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    @Query(value = "Select password from utente where username like ?1", nativeQuery = true)
    String getUserPass(String username);
    
    @Query(value = "Select id_utente, nome, cognome, username, indirizzo, password, email from utente where username like ?1", nativeQuery = true)
    Utente getUtenteByUser(String username);
}
