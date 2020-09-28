package com.eros.negozio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="amministratore")
public class Amministratore implements Serializable {
    private static final long serialVersionUID = 3117278003491113422L;
   
    public Amministratore() {
    }
    
    public Amministratore(String username, String password, String email) {
	this.username = username;
	this.password = password;
	this.email = email;
    }
    @Id
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    
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
