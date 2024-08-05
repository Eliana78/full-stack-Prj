package com.Bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="libri")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String autore;
	
	@Column(nullable=false)
	private String titolo;
	
	private Double prezzo;
	
	private String immagine;
	
	@Column(name="libro_trama", length=500)
	private String trama;
	
	@Enumerated(EnumType.STRING)
	 private Categoria categoria;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ordine_id")
	private Ordine ordine;


public Libro() {
	// TODO Auto-generated constructor stub
}


public Libro(Integer id, String autore, String titolo, Double prezzo, String immagine, String trama,
		Categoria categoria, Ordine ordine) {
	super();
	this.id = id;
	this.autore = autore;
	this.titolo = titolo;
	this.prezzo = prezzo;
	this.immagine = immagine;
	this.trama = trama;
	this.categoria = categoria;
	this.ordine = ordine;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getAutore() {
	return autore;
}


public void setAutore(String autore) {
	this.autore = autore;
}


public String getTitolo() {
	return titolo;
}


public void setTitolo(String titolo) {
	this.titolo = titolo;
}


public Double getPrezzo() {
	return prezzo;
}


public void setPrezzo(Double prezzo) {
	this.prezzo = prezzo;
}


public String getImmagine() {
	return immagine;
}


public void setImmagine(String immagine) {
	this.immagine = immagine;
}


public String getTrama() {
	return trama;
}


public void setTrama(String trama) {
	this.trama = trama;
}


public Categoria getCategoria() {
	return categoria;
}


public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}


public Ordine getOrdine() {
	return ordine;
}


public void setOrdine(Ordine ordine) {
	this.ordine = ordine;
}



}

