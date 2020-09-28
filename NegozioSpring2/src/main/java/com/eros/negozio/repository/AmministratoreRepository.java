package com.eros.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eros.negozio.model.Amministratore;

@Repository("amministratoreRepository")
public interface AmministratoreRepository extends JpaRepository<Amministratore, String> {
    @Query(value = "Select password from amministratore where username like ?1", nativeQuery =  true)
    String getAdminPass(String username);
    
    @Query(value = "Select * from amministratore where username like ?1", nativeQuery = true)
    Amministratore getAdminByUser(String username);
}
