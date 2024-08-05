package com.Esame.entities;

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
@Table(name="clienti")
 public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cliente")
	private Integer id;
	
	private String  cognome;
	private String nome;
	
	@Column(nullable=false, length=14)
	private String telefono;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	
	@OneToMany(mappedBy="cliente",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Biglietto> biglietti;

	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Biglietto> getBiglietti() {
		return biglietti;
	}



	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}
	
	
	
}
