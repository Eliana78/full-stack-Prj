package com.Esame.entities;

import java.time.LocalDate;
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
@Table(name="repliche")
public class Replica {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_replica")
	private String codReplica;
	
	
	@Column(name="data_replica")
	private LocalDate date;
	
	
	@OneToMany(mappedBy="replica",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Biglietto> biglietti;
	
	@ManyToOne
	@JoinColumn(name="cod_spettacolo")
	private Spettacolo spettacolo;
	
	public Replica() {
		// TODO Auto-generated constructor stub
	}



	public String getCodReplica() {
	return codReplica;
}

	public void setCodReplica(String codReplica) {
	this.codReplica = codReplica;
}



	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Biglietto> getBiglietti() {
		return biglietti;
	}

	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}

	public Spettacolo getSpettacolo() {
		return spettacolo;
	}

	public void setSpettacolo(Spettacolo spettacolo) {
		this.spettacolo = spettacolo;
	}
	
	
	
	
	
	
}
