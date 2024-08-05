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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="spettacoli")
public class Spettacolo {

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_spettacolo")
	private String codSpettacolo;
	
	
	String titolo;
	
	String autore;
	
	String registra;
	
	double prezzo;
	
	@OneToMany(mappedBy="spettacolo",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Replica> repliche;
	
	
	@ManyToOne
	@JoinColumn(name="cod_teatro")
	Teatro teatro;
	
	
	
	public Spettacolo() {
		// TODO Auto-generated constructor stub
	}





	public String getCodSpettacolo() {
		return codSpettacolo;
	}



	public void setCodSpettacolo(String codSpettacolo) {
		this.codSpettacolo = codSpettacolo;
	}



	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getRegistra() {
		return registra;
	}


	public void setRegistra(String registra) {
		this.registra = registra;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public List<Replica> getRepliche() {
		return repliche;
	}


	public void setRepliche(List<Replica> repliche) {
		this.repliche = repliche;
	}


	public Teatro getTeatro() {
		return teatro;
	}


	public void setTeatro(Teatro teatro) {
		this.teatro = teatro;
	}
	
	
}
