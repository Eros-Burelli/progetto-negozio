package com.eros.negozio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo implements Serializable{
    private static final long serialVersionUID = -7588506108065735891L;
    
    public Articolo() {
	
    }
    
    public Articolo(String marca, String modello, Double prezzo) {
	super();
	this.marca = marca;
	this.modello = modello;
	this.prezzo = prezzo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Articolo;
    
    @Column(name = "marca", nullable = false)
    private String marca;
    
    @Column(name = "modello", nullable = false)
    private String modello;
    
    @Column(name = "prezzo", nullable = false)
    private Double prezzo;

    
    public Long getId_Articolo() {
        return id_Articolo;
    }
    
    public void setId_Articolo(Long id_Articolo) {
        this.id_Articolo = id_Articolo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
 
    
    
}
