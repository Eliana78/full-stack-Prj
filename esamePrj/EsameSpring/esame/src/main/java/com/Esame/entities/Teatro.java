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
@Table(name="teatri")
public class Teatro {

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_teatro")
	private String codTeatro;
	
	
	private String nome;
	
	private String indirizzo;
	
	private String citta;
	
	private String provincia;
	
	@Column(nullable=false, length=14)
	private String telefono;
	
	private int posti;
	
	@OneToMany(mappedBy="teatro", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Spettacolo> spettacoli;
	
	
	public Teatro() {
		// TODO Auto-generated constructor stub
	}


	




	public String getCodTeatro() {
		return codTeatro;
	}










	public void setCodTeatro(String codTeatro) {
		this.codTeatro = codTeatro;
	}










	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getPosti() {
		return posti;
	}


	public void setPosti(int posti) {
		this.posti = posti;
	}


	public List<Spettacolo> getSpettacoli() {
		return spettacoli;
	}


	public void setSpettacoli(List<Spettacolo> spettacoli) {
		this.spettacoli = spettacoli;
	}
	
	
	
}
