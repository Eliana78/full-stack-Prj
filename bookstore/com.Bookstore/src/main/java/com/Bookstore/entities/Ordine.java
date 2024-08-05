package com.Bookstore.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="ordini")
public class Ordine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	int quantita;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="utente_id")
    private Utente utente;
    
    
	@OneToMany(mappedBy="ordine")
    private List<Libro> libri;
	
	
	public Ordine() {
		
	}


	public Ordine(Integer id, int quantita, Utente utente, List<Libro> libri) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.utente = utente;
		this.libri = libri;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public List<Libro> getLibri() {
		return libri;
	}


	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	
	
	
}