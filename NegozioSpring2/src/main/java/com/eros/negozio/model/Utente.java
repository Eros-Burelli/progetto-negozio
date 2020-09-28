package com.eros.negozio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente implements Serializable {
    private static final long serialVersionUID = 1229521831173311515L;

    public Utente() {
    }

    public Utente(String nome, String cognome, String username, String indirizzo, String password, String email) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.username = username;
	this.password = password;
	this.email = email;
	this.indirizzo = indirizzo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Utente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    public String getIndirizzo() {
	return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
	this.indirizzo = indirizzo;
    }

    public Long getId_Utente() {
	return id_Utente;
    }
    
    public void setId_Utente(Long id_Utente) {
        this.id_Utente = id_Utente;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCognome() {
	return cognome;
    }

    public void setCognome(String cognome) {
	this.cognome = cognome;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
