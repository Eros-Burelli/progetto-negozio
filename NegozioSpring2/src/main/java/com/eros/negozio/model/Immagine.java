package com.eros.negozio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "immagine")
public class Immagine implements Serializable {
    private static final long serialVersionUID = -8560671503963431081L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idImg;

    @Column(name = "nome")
    private String nome;

    @Column(name = "picByte")
    private byte[] picByte;

    public Immagine() {

    }

    public Immagine(String nome, byte[] picByte) {
	super();
	this.nome = nome;
	this.picByte = picByte;
    }

    public Long getIdImg() {
        return idImg;
    }

    public void setIdImg(Long idImg) {
        this.idImg = idImg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }


    
}
