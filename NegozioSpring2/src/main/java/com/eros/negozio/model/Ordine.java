package com.eros.negozio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine implements Serializable {
    private static final long serialVersionUID = 5890650712557963255L;
 
    public Ordine() {
	
    }
    
    public Ordine(Double totale, Date data, Utente utente) {
	super();
	this.totale = totale;
	this.data = data;
	this.utente = utente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Ordine;
    
    @Column(name = "totale", nullable = false)
    private Double totale;
    
    @Column(name = "data", nullable = false)
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Utente utente;
    

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Long getId_Ordine() {
        return id_Ordine;
    }
    
    
    
}
