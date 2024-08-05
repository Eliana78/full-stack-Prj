package com.Bookstore.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="utenti")
public class Utente {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String username;
	
	@Column(name="user_email" , nullable=false , unique=true)
	private String email;
	
	@Column(name="user_password" , nullable=false , unique=true)
	private String password;
	
	
	@OneToMany(mappedBy ="utente" , cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Ordine> ordine;
	
	public Utente() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Utente(Integer id, String name, String username, String email, String password, List<Ordine> ordine) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.ordine = ordine;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ordine> getOrdine() {
		return ordine;
	}

	public void setOrdine(List<Ordine> ordine) {
		this.ordine = ordine;
	}
	
	
}
